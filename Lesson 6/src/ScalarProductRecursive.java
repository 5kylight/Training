import java.util.concurrent.RecursiveTask;

/**
 * Created by tom on 19.02.15.
 */
public class ScalarProductRecursive extends RecursiveTask<Double> {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private Double[] vectorA;
    private Double[] vectorB;
    private int startIndex;
    private int endIndex;

    public ScalarProductRecursive(
                                    Double[] vectorA,
                                    Double[] vectorB,
                                    int startIndex,
                                    int endIndex) {
        this.vectorA = vectorA;
        this.vectorB = vectorB;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }



    @Override
    protected Double compute() {
        if(endIndex-startIndex<(vectorB.length/AVAILABLE_PROCESSORS))
            return computeDirectly();
        ScalarProductRecursive firstPart = (
                new ScalarProductRecursive(
                        vectorA,
                        vectorB,
                        startIndex,
                        startIndex+endIndex/2));
        ScalarProductRecursive secondPart = (
                new ScalarProductRecursive(
                        vectorA,
                        vectorB,
                        startIndex+endIndex/2,
                        endIndex));
        firstPart.fork();
        secondPart.fork();
        return secondPart.join() + firstPart.join();
    }
    private Double computeDirectly(){
        double x = 0.;
        for(int i = startIndex ; i< endIndex ; i++)
            x = x + vectorA[i]*vectorB[i];
        return x;
    }
}
