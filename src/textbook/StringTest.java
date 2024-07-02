package textbook;

import java.io.File;
import java.util.StringTokenizer;

public class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        System.out.println(System.identityHashCode(str));
        //"test ok"的地址给了str，所以此时str的地址已经和this.str的地址不一样了
        str = "test ok";
        ch[0] = 'b';
        System.out.println(System.identityHashCode(this.str));
        System.out.println(System.identityHashCode(str));
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//
        System.out.println(ex.ch);
    }
}
