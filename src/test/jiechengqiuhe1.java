package test;

import java.math.BigInteger;
import java.util.Deque;

public class jiechengqiuhe1 {
    public static void main(String[] args) {

        BigInteger ans = new BigInteger("0");
        for(int i = 1; i < 50; i++){
            BigInteger temp = new BigInteger("1");
            for(int j=1; j <= i; j++){
                temp = temp.multiply(new BigInteger(String.valueOf(j)));
            }
            ans = ans.add(temp);
            System.out.println(ans);
        }
    }
}
