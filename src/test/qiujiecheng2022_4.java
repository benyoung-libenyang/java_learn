package test;

import java.math.BigInteger;
import java.util.Scanner;

public class qiujiecheng2022_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String end = "";
        for(int i = 1; i <= k; i++)
            end += "0";
        BigInteger num = new BigInteger("1");
        for(int i = 2; i <= 100; i++){
            num = num.multiply(new BigInteger(String.valueOf(i)));
            String str = num.toString();
            System.out.println(str);
        }
    }

}
