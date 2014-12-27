import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by tom on 23.12.14.
 */
public class WordsCounter {
     static  Logger logger = LogManager.getLogger(WordsCounter.class.getName());
    public  static TreeMap<String,Integer> readBookAndCountWords(String path){

        TreeMap<String, Integer> map = new TreeMap();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            reader.lines().forEach(e -> {
                for ( String word : e.split("\\s")){
                    word = word.toLowerCase().replaceAll("[\\W]|[_]|[-]", "");
                    map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
                }
            });
        } catch (FileNotFoundException e) {
            logger.error("Can't open file",e);
        } catch (IOException e) {
            logger.error("IO Exception",e);
        }
        return map;
    }

    public static void main(String[] Args){
        TreeMap<String, Integer> map = readBookAndCountWords("./book.txt");
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
