package textbook;

import java.util.Collections;

public class test_class {
    public test_class(){

    }
    private static class static_innerClass{

    }
    private abstract class innerClass_abstract  {
        private int a ;
        public abstract void print();
        public static void printHello(){
            System.out.println("hello");
        }
//        构造器
        public innerClass_abstract(){

        }
    }
    public class innerClass extends innerClass_abstract{
        @Override
        public void print() {
            System.out.println("world");
        }
    }
    public static void main(String[] args) {
        test_class.innerClass_abstract.printHello();
        test_class tt = new test_class();
        test_class.innerClass ii = tt.new innerClass();
        ii.print();

    }
    public void method(){
        final class methodinnerClass{

        }

    }
}
