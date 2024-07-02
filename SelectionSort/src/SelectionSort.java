public class SelectionSort {

    private SelectionSort(){}

//    extends表示泛型实现某一个接口
    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i = 0; i < arr.length; i++){
//            循环不变量：[0, i]之间的数组顺序已经排列好了
//            选择arr[i:n]中最小值索引
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
//                compareTo() 前 - 后
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int minIndex){
        E t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for(int n : dataSize){
            Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }


/*
        Student[] students = {new Student("Alice", 89),
                                new Student("benyoung", 100),
                                new Student("qingqing", 101)};
        SelectionSort.sort(students);
//        toString,因为重写了方法才可以打印这个对象。
        for (Student student : students)
            System.out.println(student);

 */


    }
}
