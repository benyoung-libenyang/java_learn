import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        BigInteger bigInteger=new BigInteger("1");
        BigInteger sum=new BigInteger("1");
        BigInteger sum2=new BigInteger("0");
        while(bigInteger.compareTo(new BigInteger("50"))==-1){
            sum=sum.multiply(bigInteger);
            sum2=sum2.add(sum);
            System.out.println(sum2);
            bigInteger=bigInteger.add(new BigInteger("1"));
        }
        System.out.println(sum2.mod(new BigInteger("1000000000")));
    }
}