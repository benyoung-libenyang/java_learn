import java.util.Arrays;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
//      查找的是每趟船运送的最大吨数, 且包裹不可拆分
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while(l < r){
            int mid = l + (r-l)/2;
            if(needDay(weights, mid) <= days)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    /**
     * weight[]的包裹，每天运送mid， 需要的天数， 包裹不可拆分
     * @param weights
     * @param mid
     * @return day
     */
    private int needDay(int[] weights, int mid){
//        需要运送的天数
        int day = 1;
//        当前船的重量是否超过了mid
        int cur = 0;
        for(int weight : weights){
            if(cur + weight > mid){
                day++;
                cur = 0;
            }
            cur += weight;
        }
        return day;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(solution.shipWithinDays(weights, days));
    }
}