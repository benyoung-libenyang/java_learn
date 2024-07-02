package chap06;

import chap04.MaximumSubarray;

import java.util.Arrays;

public class MaxHeapify_Rescursive {
    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return 2*i + 1;
    }
    private int right(int i){
        return 2*(i+1);
    }
    private void swap(int[] A, int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
    //维持最大堆
    public void maxHeapify(int[] A, int i, int heapSize){
        int l = left(i);
        int r = right(i);
        int largest = 0;
        if((l <= heapSize) && (A[l] > A[i])){
            largest = l;
        }else
            largest = i;
        if((r <= heapSize) && (A[r] > A[largest])){
            largest = r;
        }
        if(largest != i){
            swap(A, i, largest);
            maxHeapify(A, largest, heapSize);
        }
    }
    //建堆
    public void buildMaxHeap(int[] A){
        for(int i = A.length/2; i >= 0; i--){
            maxHeapify(A, i, A.length-1);
        }
    }
    public void heapSort(int[] A){
        buildMaxHeap(A);
        int heapSize = A.length - 1;
        for(int i = A.length-1; i >= 0; i--){
            swap(A, i, 0);
            heapSize -- ;
            maxHeapify(A, 0, heapSize);
        }
    }
    public static void main(String[] args) {
        int[] A = {4,1,3,2,16,9,10,14,8,7};
        MaxHeapify_Rescursive M = new MaxHeapify_Rescursive();
        M.heapSort(A);
        for(int i : A){
            System.out.println(i);
        }
    }
}
