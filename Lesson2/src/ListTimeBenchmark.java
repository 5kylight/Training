import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by tom on 21.12.14.
 */
public class ListTimeBenchmark {
    public static void main(String[] Args) {
        int a = (int) Math.pow(10, 7);

        // Checking time on ArrayList
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < a; ++i) {
            arrayList.add((new Random()).nextInt());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("This action on ArrayList took " + (endTime - startTime) + " miliseconds");


        // Checking time on ArrayList with InitialCapacity

        ArrayList<Integer> secondArrayList = new ArrayList<Integer>(a);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < a; ++i) {

            secondArrayList.add((new Random()).nextInt());

        }
        endTime = System.currentTimeMillis();
        System.out.println("This action on ArrayList took " + (endTime - startTime) + " miliseconds");

        // Seems that initial Capacity make better time :

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < a; ++i) {linkedList.add((new Random()).nextInt());}
        endTime = System.currentTimeMillis();
        System.out.println("This action on Linked took " + (endTime - startTime) + " miliseconds");

        // And the Winner is LinkedList (only in adding Time)

    }


}