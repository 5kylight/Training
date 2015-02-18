import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by tom on 18.02.15.
 */
public class Rand implements Callable<Integer> {
    private int number;

    public Rand(int number){
        this.number = number;
    }
    @Override
    public Integer call() throws Exception {
        int busted = 0 ;
        Random random = new Random();

        for(int i = 0 ; i < number ; i++){
            double x = random.nextDouble()*2 - 1;
            double y = random.nextDouble()*2 - 1;
            if(x*x + y*y <= 1 )
                busted++;
        }
        return busted;
    }
}
