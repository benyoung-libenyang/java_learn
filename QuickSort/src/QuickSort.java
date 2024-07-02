import java.util.Random;

public class QuickSort {

    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 1.对于大概有序的数组排序的效果非常的不好
     * 2.对于全部相等的数组排序效果也有问题
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l >= r)
            return ;
        int p = partition2(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }


    /**
     * 单路排序，
     * 对于0 0 0 0 0 0，相同的数据就会出现取中间数据p位置出现在特定的一边
     * @param arr
     * @param l
     * @param r
     * @return
     * @param <E>
     */
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r){
//        生成[l, r]之间的随机索引, 解决大概有序的数组排序
        int p = l + (new Random()).nextInt(r - l +1);
        swap(arr, l, p);
        E tmp = arr[l];
        int j = l;
//        arr[l+1...j] <= tmp; arr[j+1...i] > tmp
//        j指向的是小于等于tmp的位置， i指向的是最新的元素，
        for(int i = l+1; i < r+1; i++) {
            if (arr[i].compareTo(tmp) <= 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    /**
     * 双路快速排序算法
     * @param arr
     * @param l
     * @param r
     * @return j
     * @param <E>
     */
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r){
        int p = l + (new Random()).nextInt(r - l);
        swap(arr, l, p);
//        循环不变量：[l+1, i-1] <= v, [j+1, r] >= v
//        if arr[i] >= v i停止
//        if arr[j <= v j停止
        int i = l+1, j = r;
        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) < 0)
                i++;
            while(i <= j && arr[j].compareTo(arr[l]) > 0)
                j--;
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    /***
     *
     * @param arr
     * @param a
     * @param b
     * @param <E>
     */
    private static <E extends Comparable<E>> void swap(E[] arr, int a, int b){
        E tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] n = {10000, 1000000};
        for(int i : n){
            Integer[] arr = ArrayGenerator.generatorRandomArray(i);
            SortingHelper.sortTest("QuickSort", arr);
        }
    }
}
