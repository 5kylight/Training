package home.training.lessons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.HashMap;

/**
 * Created by tom on 21.12.14.
 */
public class Logging {



    public static void main(String[] Args) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("kot", 15);
       System.out.print(map.get("kot"));

        Logger logger = LogManager.getLogger();
        logger.info("Main Stared");
        System.out.println("Hi!");

        Tree<Integer> tree = new Tree<Integer>();
        for(int i = 0 ; i <10 ; ++i){
            tree.insert(i);
        }
        tree.insert(14);
        tree.preorder();
        tree.inorder();
        logger.info("Main Finished");



    }

}
