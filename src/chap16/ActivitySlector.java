package chap16;

import java.util.ArrayList;

public class ActivitySlector {
    public static void activitySelectorRecursive(int[] s, int[] f, int k, int n, ArrayList<Integer> res){
        int m = k+1;
        while(m <= n && s[m] < f[k])
            m += 1;
        if(m <= n){
            res.add(m);
            activitySelectorRecursive(s, f, m, n, res);
        }else{
            return ;
        }
    }
    public static void activitySelectorGreedy(int[] s, int[] f, ArrayList<Integer> res){
        int n = s.length;
        res.add(1);
        int k = 1;
        for(int m = 2; m < n; m++){
            if(s[m] >= f[k]){
                res.add(m);
                k = m;
            }
        }
        return ;
    }
    public static void main(String[] args) {
        int[] s = {0,1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {0,4,5,6,7,9,9,10,11,12,14,16};
        ArrayList<Integer> res = new ArrayList<Integer>();
        activitySelectorGreedy(s, f, res);
        for(int i = 0; i < res.size(); i ++){
            System.out.println(res.get(i));
        }
    }
}
