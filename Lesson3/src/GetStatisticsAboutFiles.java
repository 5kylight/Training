import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;


/**
 * Created by tom on 23.12.14.
 */
public class GetStatisticsAboutFiles {
    public static void main(String[] Args){
        Path startPath = Paths.get("/home/tom/Pulpit");

        FileVisitorImpl visitor = new FileVisitorImpl();

        try {
            Files.walkFileTree(startPath, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Getting top 5 files with biggest size
        TreeMap<Long, String> map = visitor.getSet();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outPutForGetStatisticsAboutFiles.txt")))        {
            for (int i = 0 ; i < 5 ; i++){
                writer.write(map.descendingKeySet().toArray()[i]+" "+map.descendingMap().values().toArray()[i]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        (new SerializePojoObject()).serialize();
    }
}
