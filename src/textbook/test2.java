package textbook;

public class test2 extends test1 {
    static void f(){
        m = 222;
    }
    public class innerClass{
        public static int a = 1;
        public static void ff(){
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        char ch = '\u1001';
        char ch1 = '\ucafe';
        System.out.println(ch1);
        int m = 10;
        //比较运算符产生的是false
        while(m == 1){

        }
        char a = 'a';
//        char b = a + 1;
        char c = 'a' + 1;
//        a = a +  a;
        char good_cl = 30320;
        
        System.out.println(good_cl);
    }
}
