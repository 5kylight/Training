import org.perf4j.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by tom on 19.02.15.
 */
public class StreamVsOldWay {
    public static void main(String[] args){
        StopWatch stopWatch = new StopWatch();
        int vectorSize = 1_000_000;
        Float[] vectorA = new Float[vectorSize];
        Float[] vectorB = new Float[vectorSize];
        Random random = new Random();

        // Using Java 8 Streams
        IntStream.range(0, vectorSize).forEach(v -> {
            vectorA[v] = random.nextFloat();
//            vectorB[v] = random.nextFloat();
        });
        double z;
        stopWatch.start();
        z = Arrays.stream(vectorA).map(v -> Math.pow(v,2)).reduce(
                (double) 0,
                (a,b)->a+b);
//        Arrays.stream(vectorB).forEach(v -> Math.pow(v, 2));


        stopWatch.stop();
        System.out.println(z);
        System.out.println("Arrays.stream took: " + stopWatch.getElapsedTime());

        // Using old way

        stopWatch.start();
        double x = 0 ;
        for( int i = 0 ; i < vectorSize ; i++ ) {
            x = x +  Math.pow(vectorA[i], 2);
        }

        stopWatch.stop();
        System.out.println("Old ways took: "+ stopWatch.getElapsedTime());
        System.out.println(x);

    }
}
