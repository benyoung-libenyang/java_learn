package chap04;

public class MaximumSubarray {

    private class MaxSubArrayBean{
        public int maxLeft;
        public int maxRight;
        public int sumValue;

        public MaxSubArrayBean(int maxLeft, int maxRight, int sumValue){
            this.maxLeft = maxLeft;
            this.maxRight = maxRight;
            this.sumValue = sumValue;
        }

        @Override
        public String toString() {
            return "maxRight:" + maxRight +", maxRight:" + maxRight + ", sumValue:" + sumValue;
        }
    }
    private MaxSubArrayBean findMaxCrossingSubArray(int[] arr, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for(int i = mid; i >= low; i--){
            sum += arr[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }
        int righSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid+1;
        for(int j = mid+1; j <= high; j++){
            sum += arr[j];
            if(sum > righSum){
                righSum = sum;
                maxRight = j;
            }
        }
        return new MaxSubArrayBean(maxLeft, maxRight, leftSum+righSum);
    }
    public MaxSubArrayBean findMaximumSubarray(int[] arr, int low, int high){
        if(high == low)
            return new MaxSubArrayBean(low, high, arr[high]);
        else{
            int mid = (low+high)/2;
            MaxSubArrayBean left = findMaximumSubarray(arr, low, mid);
            MaxSubArrayBean right = findMaximumSubarray(arr, mid+1, high);
            MaxSubArrayBean cross = findMaxCrossingSubArray(arr, low, mid, high);
            if(left.sumValue >= right.sumValue && left.sumValue >= cross.sumValue)
                return left;
            else if (right.sumValue >= left.sumValue && right.sumValue >= cross.sumValue) {
                return right;
            }else{
                return cross;
            }
        }
    }
    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] arr = {-13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        MaxSubArrayBean maxSubArrayBean = maximumSubarray.findMaximumSubarray(arr,0,arr.length-1);
        System.out.println(maxSubArrayBean.sumValue);
    }
}
