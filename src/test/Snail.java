package test;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n+1];
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for(int i = 1; i <= n; i++){
            x[i] = scanner.nextInt();
        }
        for(int i = 1; i < n; i++){
            a[i] = scanner.nextInt();
            b[i+1] = scanner.nextInt();
        }

        //dp[0]到达节点的最短时间
        //dp[1]到达传送点入口的时间
        double[][] dp = new double[n+1][2];
        dp[1][0] = x[1];
        dp[1][1] = x[1] + a[1]/(0.7);

        for(int i=2; i <= n; i++){
            if(a[i] > b[i])
                dp[i][1] = Math.min(dp[i-1][1] + (a[i]-b[i])/(0.7), dp[i-1][0] + x[i]-x[i-1] + a[i]/0.7);
            else
                dp[i][1] = Math.min(dp[i-1][1] + (b[i]-a[i])/(1.3), dp[i-1][0] + x[i]-x[i-1] + a[i]/0.7);
            dp[i][0] = Math.min(dp[i-1][1] + b[i]/1.3, dp[i-1][0]+x[i]-x[i-1]);
        }

        System.out.printf("%.2f", dp[n][0]);
    }
    /*
    3
    1 10 11
    1 1
    2 1
    * */
}
