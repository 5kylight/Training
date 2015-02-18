import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tom on 01.01.15.
 */
public class SearchAndAddFiles extends Thread {
    private String[] extensions;
    private String startPath;
    public LinkedBlockingQueue<String> files;


    public SearchAndAddFiles(String[] extensions, String startPath, LinkedBlockingQueue files){
        this.files = files;
        this.startPath = startPath;
        this.extensions = extensions;
    }


    public void run(){
        addFiles();
    }

    private void addFiles() {
        AddFilesVisitor filesVisitor = new AddFilesVisitor(extensions, files);
        try {
            Files.walkFileTree(Paths.get(startPath),filesVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
