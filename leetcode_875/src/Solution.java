import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
//        获取数组中的最大值
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while(l < r){
            int mid = l + (r-l)/2;
            if(eatingTime(piles, mid) <= h)
                r = mid ;
            else
                l = mid + 1;
        }
        return l;
    }

    private int eatingTime(int[] piles, int k ){
        int res = 0;
        for(int pile : piles){
            res += pile/k + (pile%k > 0 ? 1 : 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] piles = {3, 6, 7, 11};
        int H = 8;
        System.out.println(test.minEatingSpeed(piles, H));
    }
}
