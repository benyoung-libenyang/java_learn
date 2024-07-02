package chap07;

public class QuickSort {
    public static void quickSort(int[] A, int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
    }
    private static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                i += 1;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);
        return i+1;
    }
    private static void swap(int[] A, int m ,int n){
        int tmp = A[m];
        A[m] = A[n];
        A[n] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {2,8,7,1,3,5,6,4};
        QuickSort.quickSort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
