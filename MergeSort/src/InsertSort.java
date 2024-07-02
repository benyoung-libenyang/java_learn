public class InsertSort {

    private InsertSort(){}

    public static<E extends Comparable<E>> void sort1(E[] arr){
        for(int i = 0; i< arr.length; i++){
            E tmp = arr[i];
            int j;
            for(j = i; j > 0 && tmp.compareTo(arr[j-1]) < 0; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

    public static<E extends Comparable<E>> void sort(E[] arr, int l, int r){
        for(int i = l; i < r; i++){
            E tmp = arr[i];
            int j;
            for(j = i; j > l && tmp.compareTo(arr[j-1]) < 0; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }
}
