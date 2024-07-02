import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator(){}
    public static Integer[] generatorOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generatorRandomArray(int n, int bound){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
