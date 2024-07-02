public class InsertSort {

    private InsertSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i = 0; i < arr.length; i++) {
//            [0,i]之间是已经排好序的，循环不变量，每次插入arr[i]到合适的位置
            for (int j = i; j > 0; j--)
                if (arr[j].compareTo(arr[j - 1]) < 0)
                    swap(arr, j, j - 1);
                else
                    break;
        }
    }

//    特性： 对于大概顺序正确的O（n）级别
    public static <E extends Comparable<E>> void sort2(E[] arr){
        for (int i = 0; i < arr.length; i++) {
//            循环不变量： [0,i]已经排好序了，
//            i = arr.length 退出循环，【0， arr.length - 1】
            E tmp = arr[i];
            int j ;
            for (j = i; j > 0; j--) {
//                循环不变量: [j, i]都比tmp大；
//                考虑边界：j = 0 时退出循环，思考如果最小值应该怎么赋值呢
                if (tmp.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j-1];
                } else {
                    break;
                }
            }
            arr[j] = tmp;
        }
    }

    private static <E> void swap(E[] arr, int a, int b){
        E tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize){
            Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
            SortingHelper.SortTest("InsertSort", arr);
        }
    }
}
