public class BinarySearch {
    /**
     * 二分查找法， 有序数组
     * 查找target存不存在
     */
    private BinarySearch(){}

    /**
     * 递归
     */
    public static <E extends Comparable<E>> int searchR(E[] data, E target){
        return searchR(data, 0, data.length, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] arr, int l, int r, E target){
        if (l > r) return -1;

        int mid = l + (r-l)/2;
        if(arr[mid].compareTo(target) == 0)
            return mid;
        if(arr[mid].compareTo(target) < 0)
            return searchR(arr, mid+1, r, target);

        return searchR(arr, l, mid-1, target);
    }

    /**
     * 非递归
     * @param data
     * @param target
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> int search(E[] data, E target){
        int l = 0, r = data.length-1;
//        循环不变量 ： [l,r]一直对半分区间，直到无空间或者找到了target
        while(l <= r){
            int mid = l + (r-l)/2;

            if(data[mid] == target)
                return mid;
            if(data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
    /**
     * 二分查找法的变形 upper
     * 在数组中查找大于target的最小索引
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target){
//        target 比 整个数组都大， 返回data.length
        int l = 0, r = data.length;
//        循环不变量： [l, r] 中二分查找法查找大于target, 终止条件一定是r == l
        while(l < r){
//            向下取整
            int mid = l + (r-l)/2;
            if(data[mid].compareTo(target) > 0)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    /**
     * 二分查找法变形， ceil， 天花板
     * 如果数组中存在元素， 返回最大索引
     * 如果数组中不存在元素， 返回upper
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target){
        int u = upper(data, target);
        if(u-1 >= 0 && data[u-1].compareTo(target) == 0)
            return u-1;
        return u;
    }

    /**
     *二分查找法变形， lower_ceil，
     *查找小于target的最大值的索引
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target){
        int l = -1, r = data.length-1;
//        [l, r]中寻找解
        while(l < r){
//            上取整方法， [0, 1]
            int mid = l + (r-l+1)/2;
            if(data[mid].compareTo(target) < 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }
    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        System.out.println(BinarySearch.lower(arr, 2));
    }
}
