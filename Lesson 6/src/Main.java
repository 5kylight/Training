import org.perf4j.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by tom on 18.02.15.
 */
public class Main {
    public static void main(String[] args){

        StopWatch stopWatch = new StopWatch();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        int n = 100000000;
        int k = 10;
        Future[] futures = new Future[k];
        stopWatch.start();
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
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        System.out.println("By FixedThreadPool this action took: (+/-10ms) " +
                stopWatch.getElapsedTime() + " ms");


        // CachedThreadPool
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        Future[] futures1 = new Future[k];
        stopWatch.start();
        for(int i = 0; i < k ; i++){
            futures1[i]= executorService1.submit(new Rand(n/k));
        }
        flag = true;
        while(true) {
            for (int i = 0; i < k; i++)
                if (!futures1[i].isDone()) {
                    flag = false;
                    break;
                }
            if (flag)
                break;
            flag = true;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        System.out.println("By CachedThreadPool this action took: (+/-10ms) " +
                stopWatch.getElapsedTime() + " ms");

        // SingleThreadPool
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future[] futures2 = new Future[k];
        stopWatch.start();
        for(int i = 0; i < k ; i++){
            futures2[i]= executorService2.submit(new Rand(n/k));
        }
        flag = true;
        while(true) {
            for (int i = 0; i < k; i++)
                if (!futures2[i].isDone()) {
                    flag = false;
                    break;
                }
            if (flag)
                break;
            flag = true;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        System.out.println("By SingleThreadPool this action took: (+/-10ms) " +
                stopWatch.getElapsedTime() + " ms");

        // ScheduledThreadPool
        ExecutorService executorService3 = Executors.newScheduledThreadPool(4);
        Future[] futures3 = new Future[k];
        stopWatch.start();
        for(int i = 0; i < k ; i++){
            futures3[i]= executorService3.submit(new Rand(n/k));
        }
        flag = true;
        while(true) {
            for (int i = 0; i < k; i++)
                if (!futures3[i].isDone()) {
                    flag = false;
                    break;
                }
            if (flag)
                break;
            flag = true;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        System.out.println("By ScheduledThreadPool this action took: (+/- 10ms) " +
                stopWatch.getElapsedTime() + " ms");




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
