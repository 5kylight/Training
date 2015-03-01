import java.util.Observable;
import java.util.Observer;

/**
 * Created by tom on 19.02.15.
 */
public class FilesObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Dictio");
    }
}
