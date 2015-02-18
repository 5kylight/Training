import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by tom on 18.02.15.
 */
public class Main {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        int n = 1000000000;
        int k = 10;
        Future[] futures = new Future[k];

        for(int i = 0; i < k ; i++){
            futures[i]= executorService.submit(new Rand(n/k));
        }
        boolean flag = true;
        while(true) {
            for (int i = 0; i < k; i++)
                if (!futures[i].isDone()) {
                    flag = false;
                    break;
                }
            if (flag)
                break;
            flag = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double x = 0 ;
        for(int j = 0 ; j < k ; j++) {
            try {
                x = (int)futures[j].get() + x;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pi equals:  " + (4 * x/n) );



    }
}
