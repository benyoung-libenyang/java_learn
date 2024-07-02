package textbook;


public class test_precision {
    public static void main(String[] args) {
        int x = 1;
        char a;
        try{
//            a = 'b' + x;编译错误，不是异常。
        }catch (Exception e){
            System.out.println(e);
        }
        String str = "abc";
        try{
            byte[] bb = str.getBytes("utf-8");
            System.out.println(bb[0]);
            str.contains("ab");
        }catch (Exception e){

        }
    }
}
