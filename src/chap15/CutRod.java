package chap15;

import java.util.Arrays;

public class CutRod {
    public static int cutRod_recursion(int[] p, int n){
        if(n == 0)
            return 0;
        int q = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++)
            q = Math.max(q, p[i]+p[n-i]);
        return q;
    }
    public static int cutRod_Memoized(int[] p, int n){
        int[] r = new int[n+1];
        Arrays.fill(r, Integer.MIN_VALUE);
        return curRod_Memoized_Aux(p, n, r);
    }
    private static int curRod_Memoized_Aux(int[] p, int n, int[] r){
        if(r[n] >= 0)
            return r[n];
        int q;
        if(n == 0)
            q = 0;
        else{
            q = Integer.MIN_VALUE;
            for(int i = 1; i <= n; i++)
                q = Math.max(q, p[i] +curRod_Memoized_Aux(p, n-i, r));
        }
        r[n] = q;
        return q;
    }
    public static int cutRod_bottom_up(int[] p, int n){
        int[] r = new int[n+1];
        Arrays.fill(r, Integer.MIN_VALUE);
        r[0] = 0;
        for(int j = 1; j <= n; j++){
            int q = Integer.MIN_VALUE;
            for(int i = j; i > 0; i--)
                q = Math.max(q, p[i]+r[j-i]);
            r[j] = q;
        }
        return r[n];
    }
    public static void main(String[] args) {
        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
        System.out.println(cutRod_recursion(p,7));
        System.out.println(cutRod_Memoized(p, 7));
        System.out.println(cutRod_bottom_up(p, 7));
    }
}
