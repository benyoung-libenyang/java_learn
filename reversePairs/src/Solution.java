public class Solution {
    public int reversePairs(int[] nums){
        int[] tmp = new int[nums.length];
        return sort(nums, 0, nums.length-1, tmp);
    }

    private int sort(int[] nums, int l, int r, int[] tmp){
        if (l >= r)
            return 0 ;
        int res = 0;
        int mid = l + (r-l)/2;
        res += sort(nums, l, mid, tmp);
        res += sort(nums, mid+1, r, tmp);
        if(nums[mid] > nums[mid+1])
            res += merge(nums, l, mid, r, tmp);
        return res;
    }

    private int merge(int[] nums, int l, int mid, int r, int[] tmp){
        System.arraycopy(nums, l, tmp, l, r-l+1);
        int i = l, j = mid+1, res = 0;
//        循环不变量，每次改变的是nums里第k个值；
        for(int k = l; k < r+1; k++){
            if(i > mid){
                nums[k] = tmp[j]; j++;
            } else if (j > r) {
                nums[k] = tmp[i]; i++;
            } else if (tmp[i] > tmp[j]) {
                res += mid - i + 1;
                nums[k] = tmp[j]; j++;
            } else  {
                nums[k] = tmp[i]; i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(arr));
        for(int n : arr){
            System.out.println(n);
        }
    }
}
