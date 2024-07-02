package org.hydrakyoufeng.test.hello;

public class try_jdbc {

    public static void main(String[] args) {
        try {
            System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
        }catch (Exception e){}
    }
}
