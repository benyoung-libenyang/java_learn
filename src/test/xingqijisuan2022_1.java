package test;

import java.math.BigInteger;

public class xingqijisuan2022_1 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("20");
        BigInteger b = a.pow(22);
        BigInteger c =b.mod(new BigInteger("7"));
        System.out.println(c);
    }
}
