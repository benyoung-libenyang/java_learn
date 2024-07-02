/**
 * 704 二分查找法
 */
public class Solution {
    public int search(int[] data, int target){
        int l = 0, r = data.length;
//        循环不变量 ： [l,r)一直对半分区间，直到无空间或者找到了target
//        理解函数的语义，理解参数的边界
        while(l < r){
            int mid = l + (r-l)/2;

            if(data[mid] == target)
                return mid;
            if(data[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return -1;
    }
}
