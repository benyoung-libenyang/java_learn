public class SortingHelper {

    private SortingHelper(){}

    private static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1; i < arr.length; i++)
            if(arr[i].compareTo(arr[i-1]) < 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortType, E[] arr){
        long startTime = System.nanoTime();

        if(sortType.equals("QuickSort")){
            QuickSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime)/1000000000.0;
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException("sort failed");
        else
            System.out.println(String.format("%s, n=%d: %f",sortType,arr.length, time));
    }
}
