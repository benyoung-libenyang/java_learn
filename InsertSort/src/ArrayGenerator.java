import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator(){}

    public static Integer[] generatorRandomArray(int n, int bound){
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++)
            arr[i] = random.nextInt(bound);
        return arr;
    }
}
