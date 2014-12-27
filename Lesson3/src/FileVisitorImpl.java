import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeMap;

/**
 * Created by tom on 23.12.14.
 */
public class FileVisitorImpl extends SimpleFileVisitor<Path> {


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        
        if(attrs.isRegularFile()){
            set.put(attrs.size(),file.toString());
        }

        return super.visitFile(file, attrs);
    }

    private TreeMap<Long, String> set;

    public FileVisitorImpl(){
        set = new TreeMap<>();
    }



    public TreeMap<Long, String> getSet() {
        return set;
    }

    public void setSet(TreeMap<Long, String> set) {
        this.set = set;
    }


}
