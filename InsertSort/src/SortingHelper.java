public class SortingHelper {

    private SortingHelper(){}

    private static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1; i < arr.length; i++)
            if(arr[i].compareTo(arr[i-1]) < 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void SortTest(String sortName, Integer[] arr){
        long startTime = System.nanoTime();
        if(sortName.equals("InsertSort")){
            InsertSort.sort2(arr);
        }else
            throw new RuntimeException("Select fun failed");
        long endTime = System.nanoTime();
        double time = (endTime - startTime)/1000000000.0;
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException("Selection failed");
        else
            System.out.println(String.format("%s, n=%d:%f s", sortName, arr.length, time));
    }
}
