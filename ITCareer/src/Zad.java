import java.io.*;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by tom
 */
public class Zad {

    public static void main(String[] args) {

        TreeMap<String, Integer> dictionary = new TreeMap<>(); // dictionary for counting words
        String[] words = { "red", "green", "car", "computer", "java",  "aplikacja", "tworzy", "drugi", "plik", "tekstowy"};

        Random gen = new Random();

       try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
         for (int i = 0 ; i < 1000 ; i++){ // write to file
             writer.write(words[gen.nextInt(words.length)] + "\n"); // writing to file,
         }

       } catch (IOException e) {
                e.printStackTrace();
       }

        //reading file
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))){
            reader.lines().forEach(e -> {
                for ( String word : e.split("\\s")){ // if someone give more words in line
                    dictionary.put(word, dictionary.get(word) == null ? 1 : dictionary.get(word) + 1); // counting words
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // writing result,
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("counted.txt"))){
                dictionary.forEach((k, v) -> stringBuffer.append(k + " = " + v + "\n"));
            writer.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
