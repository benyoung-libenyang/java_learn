package chap02_sort;

public class InsertionSort {
    private InsertionSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int j = 1; j < arr.length; j++){
            E key = arr[j];
            int i = j - 1;
            while(i >= 0 && arr[i].compareTo(key) > 0){
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5,2,4,6,1,3};
        InsertionSort.sort(arr);
        for(Integer i : arr){
            System.out.println(i);
        }
    }
}
