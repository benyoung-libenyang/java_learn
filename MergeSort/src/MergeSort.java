import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){

        if(l >= r) return;
//      防止整形的溢出
        int mid = l + (r - l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1 );
    }


//    对于一种特殊情况，arr[mid+1]已经大于了arr[mid]
    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r){

        if(l >= r) return;
//      防止整形的溢出
        int mid = l + (r - l)/2;
        sort2(arr, l, mid);
        sort2(arr, mid+1, r);
        if(arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort2(arr, 0, arr.length - 1 );
    }



//    对于小范围的数组排序，使用插入排序算法
    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r){

//        if(l >= r) return;
        if(r - l < 16){
            InsertSort.sort(arr, l, r+1);
            return ;
        }

//      防止整形的溢出
        int mid = l + (r - l)/2;
        sort3(arr, l, mid);
        sort3(arr, mid+1, r);
        if(arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
    }

    public static <E extends Comparable<E>> void sort3(E[] arr){
        sort3(arr, 0, arr.length - 1 );
    }

    //    合并两个有序的区间 arr[l, mid] 和 arr[mid+1, r]
    public static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
//        前闭后开
        E[] tmp = Arrays.copyOfRange(arr, l, r+1);
        int i = l, j = mid+1;
//        循环不变量：每一轮循环为arr[k]进行赋值
        for(int k = l; k < r+1; k++){
           if(i > mid){
               arr[k] = tmp[j-l]; j++;
           } else if (j > r) {
               arr[k] = tmp[i-l]; i++;
           } else if (tmp[i-l].compareTo(tmp[j-l]) < 0) {
               arr[k] = tmp[i-l]; i++;
           }else {
               arr[k] = tmp[j-l]; j++;
           }
        }
    }

//    修改了在merge中多次开tmp空间造成的内存消耗
    private static <E extends Comparable<E>> void sort4(E[] arr, int l, int r, E[] tmp){

//        if(l >= r) return;
        if(r - l < 16){
            InsertSort.sort(arr, l, r+1);
            return ;
        }

//      防止整形的溢出
        int mid = l + (r - l)/2;
        sort4(arr, l, mid, tmp);
        sort4(arr, mid+1, r, tmp);
        if(arr[mid].compareTo(arr[mid+1]) > 0 )
            merge2(arr, l, mid, r, tmp);
    }

    public static <E extends Comparable<E>> void sort4(E[] arr){
        E[] tmp = Arrays.copyOf(arr,arr.length);
        sort4(arr, 0, arr.length - 1, tmp );
    }

    //    合并两个有序的区间 arr[l, mid] 和 arr[mid+1, r]
    public static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r, E[] tmp){
//      拷贝数组
        System.arraycopy(arr, l, tmp, l, r-l+1);
//        前闭后开
        int i = l, j = mid+1;
//        循环不变量：每一轮循环为arr[k]进行赋值
        for(int k = l; k < r+1; k++){
            if(i > mid){
                arr[k] = tmp[j]; j++;
            } else if (j > r) {
                arr[k] = tmp[i]; i++;
            } else if (tmp[i].compareTo(tmp[j]) < 0) {
                arr[k] = tmp[i]; i++;
            }else {
                arr[k] = tmp[j]; j++;
            }
        }
    }


//    自底向上的归并排序
    public static <E extends Comparable<E>> void sortBU(E[] arr){
        E[] tmp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;
//      规定数组的大小
        for(int sz = 1; sz < n; sz += sz ){
//            数与数的间隔
//           合并两个区间[i, i + sz - 1] 和 [i + sz, i + sz + sz - 1]
            for(int i = 0; i + sz < n; i += sz+sz)
                if(arr[i+sz-1].compareTo(arr[i+sz]) > 0)
                    merge2(arr, i, i + sz - 1,  Math.min(i + sz +sz - 1, n - 1), tmp);
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 1000000};
        for(int n : dataSize)
        {
            Integer[] arr = ArrayGenerator.generatorRandomArray(n);
            SortingHelper.sortTest("MergeSort", arr);
        }
    }
}
