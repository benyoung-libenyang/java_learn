import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator(){}

    public static Integer[] generatorRandomArray(int n){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = random.nextInt(n);
        }
        return arr;
    }
}
