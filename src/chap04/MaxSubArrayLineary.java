package chap04;

public class MaxSubArrayLineary {
    public static int findMaxSubArray(int[] arr){
        int pre = 0, maxAns = arr[0];
        for(int x:arr){
            if((pre+x) > x){
                pre = pre +x;
            }else{
                System.out.println(pre);
                pre = x;
            }
//            pre = Math.max(pre + x, x);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        int[] arr = {-13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(findMaxSubArray(arr));
    }
}
