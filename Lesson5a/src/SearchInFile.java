import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tom on 16.02.15.
 */
public class SearchInFile extends Thread {
    private String regex;
    private LinkedBlockingQueue<String> files;
    private SearchAndAddFiles thread;
    private ConcurrentMap<String, String> result;

    public SearchInFile(String regex, LinkedBlockingQueue<String> files, SearchAndAddFiles thread, ConcurrentMap result) {
        this.regex = regex;
        this.files = files;
        this.thread = thread;
        this.result = result;
    }

    @Override
    public void run() {
        findInFiles();
    }

    private void findInFiles() {
        while (!files.isEmpty() || thread.isAlive()) {
            if (!files.isEmpty()) {
                String path = files.poll();

                List<String> list = null;
                try {
                    list = Files.readAllLines(Paths.get(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list != null) {
                    int i = 0;
                    list.forEach(v -> {
                        if (v.contains(regex)) {
                            result.put(path,v);

                        }
                    });
                }

            } else {
                if (thread.isAlive()) {
                    try {
                        Thread.sleep(500);
                        System.out.println("Waiting, list empty.. ");
                        if (files.isEmpty()) {
                            System.out.println("No more job, that I think, Am I right? ");
                            return;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}




