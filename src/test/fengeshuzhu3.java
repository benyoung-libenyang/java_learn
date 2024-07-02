package test;

import java.math.BigInteger;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class fengeshuzhu3 {
    public static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while((t--) > 0){
            int n = scan.nextInt();
            int[] arr = new int[n];
            int x = 0, y = 0;
            for(int i = 0; i < n; i++){
                arr[i] = scan.nextInt();
                if (arr[i] % 2 == 0)
                    x++;
                else y++;
            }
            if(y % 2 != 0)
                System.out.println(0);
            else
                func(x, y);
        }
        scan.close();
    }
    static void func (int x, int y){
        BigInteger bigInteger = new BigInteger("1000000007");
        BigInteger ans = new BigInteger("2");
        if(y == 0)
            System.out.println(ans.pow(x+y).mod(bigInteger));
        else
            System.out.println(ans.pow(x+y-1).mod(bigInteger));
    }
    static long myPow(long k){
        long ans = 1;
        long base = 2;
        while(k > 0){
            if(k%2 == 1) ans = ans % MOD * base % MOD;
            base = base % MOD * base % MOD;
            k /= 2;
        }
        return ans % MOD;
    }
}