import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
/**
 * Created by tom on 19.02.15.
 */
public class DirectoryWatcher {
    private Path path;
    public DirectoryWatcher (String path) {
        this.path = Paths.get(path);
    }

    public void observe(){
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchKey watchKey = path.register(watcher,
                    ENTRY_CREATE,
                    ENTRY_DELETE,
                    ENTRY_MODIFY);
            while(true){


                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

