import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tom on 01.01.15.
 */
public class AddFilesVisitor extends SimpleFileVisitor<Path> {
    private String[] extensions;
    private LinkedBlockingQueue<String> files;
    public AddFilesVisitor(String[] extensions, LinkedBlockingQueue<String> files) {
        this.files = files;
        this.extensions = extensions;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            for (String i : extensions) {
                if (file.toString().endsWith(i)) {
                    try {
                        files.put(file.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return super.visitFile(file, attrs);
    }

}