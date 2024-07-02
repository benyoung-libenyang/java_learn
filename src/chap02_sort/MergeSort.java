package chap02_sort;

public class MergeSort {
    private MergeSort(){}
    private static  void merge(int[] arr, int l, int mid, int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i = 0;i < n1; i++)
            L[i] = arr[l+i];
        for(int j = 0; j < n2; j++)
            R[j] = arr[mid+1+j];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for(int k = l; k <= r; k++){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
        }
    }
    public static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,2,4,7,1,3,2,6};
        MergeSort.mergeSort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
