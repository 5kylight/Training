import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

/**
 * Created by tom on 16.02.15.
 */
public class PrintFiles {
    private static void printAllFiles(){

        String[] extensions = {
                ".txt"
        };
        String startPath = "/home/tom/Pulpit";
        LinkedBlockingQueue<String> files = new LinkedBlockingQueue<>();
        SearchAndAddFiles addFiles = new SearchAndAddFiles(extensions,startPath,files);
        addFiles.start();


        while(true){
            if(!files.isEmpty())
                System.out.println(files.poll());
            else
                try {
                    Thread.sleep(500);
                    System.out.print("Waiting.. ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }
    static public void findInFiles(String regex){
        String[] extensions = {
                ".txt"
        };
        String startPath = "/home/tom/Pulpit";
        LinkedBlockingQueue<String> files = new LinkedBlockingQueue<>();
        SearchAndAddFiles addFiles = new SearchAndAddFiles(extensions,startPath,files);

        ConcurrentHashMap<String, String> result = new ConcurrentHashMap<>();


        addFiles.start();
        try {
            addFiles.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SearchInFile searchInFile = new SearchInFile(regex,files,addFiles,result );
        searchInFile.start();
        try {
            searchInFile.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.forEach((k,v) -> System.out.println(v+" was find in " + k ));
    }


    public static void main(String[]  args) {
        //printAllFiles();
        findInFiles("ala");

    }
}
