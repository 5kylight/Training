import org.perf4j.StopWatch;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * Created by tom on 19.02.15.
 */
public class ScalarProduct {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args){
        IntStream.range(0,100).filter(v -> v % 2 == 0 ).forEach(System.out::println);


        StopWatch stopWatch = new StopWatch();
        int vectorSize = 1_000;
        Double[] vectorA = new Double[vectorSize];
        Double[] vectorB = new Double[vectorSize];
        Random random = new Random();

        // Using Java 8 Streams
        for( int v = 0 ; v < vectorSize ; v++ ) {
            vectorA[v] = random.nextDouble();
            vectorB[v] = random.nextDouble();
        }
        stopWatch.start();
        double z = IntStream.range(0,vectorSize).mapToDouble(v -> vectorA[v]*vectorB[v] ).reduce((double)0, (a,b) -> (a+b));
        stopWatch.stop();
        System.out.println(z);
        System.out.println("Arrays.stream took: " + stopWatch.getElapsedTime());

        // Using old way
        stopWatch.start();
        double x = 0 ;
        for( int i = 0 ; i < vectorSize ; i++ ) {
            x = x +  vectorA[i]*vectorB[i];
        }
        stopWatch.stop();
        System.out.println("Old ways took: "+ stopWatch.getElapsedTime());
        System.out.println(x);

        // RecursiveTaskWay
        stopWatch.start();

        ForkJoinPool forkJoinPool = new ForkJoinPool(AVAILABLE_PROCESSORS);
        ScalarProductRecursive productRecursive = new ScalarProductRecursive(vectorA,vectorB,0,vectorSize);

        double result = forkJoinPool.invoke(productRecursive);

        stopWatch.stop();

        System.out.println("Recursive ways took: " + stopWatch.getElapsedTime());

        System.out.println(result);


    }
}