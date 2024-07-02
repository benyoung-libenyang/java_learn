package textbook;

import java.util.Random;

public class test {
//    使用final修饰成员变量，在构造器中对他final化不准再变
    private final int a ;
    {
        //也可以在代码块中初始化a
    }
    public test(){
        a= 1;
    }
    static {
        System.out.println("你好呀，我是static代码块");
    }
    public static void main(String[] args) {
        float foo = 1.4e-45f;
        System.out.println(foo);
        int[] a = new int[3];
        Random random = new Random();
        System.out.println(random);
        test tt = new test();
        System.out.println(tt.getClass());
    }
}

