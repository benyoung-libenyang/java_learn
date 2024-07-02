package chap08;

public class CountingSort {
    public static void countingSort(int[] A, int[] B, int k){
        int[] c = new int[k];
        for(int j = 0; j < A.length; j++){
            c[A[j]] += 1;
        }
        for(int i = 1; i < c.length; i++){
            c[i] += c[i-1];
        }
        for(int j = A.length-1; j >= 0; j--){
            B[c[A[j]]-1] = A[j];
            c[A[j]] -= 1;
        }
    }
    public static void main(String[] args) {
        int[] A = {2,5,3,0,2,3,0,3};
        int k = 6;
        int[] B = new int[A.length];
        CountingSort.countingSort(A, B, k);
        for(int i : B){
            System.out.println(i);
        }
    }
}
