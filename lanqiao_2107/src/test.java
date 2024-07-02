public class test {
    public static void main(String[] args) {
        String s = "123";
        int a = Integer.decode(s);
        System.out.format("value is %d", a);
        int b = Integer.parseInt(s, 8);
        System.out.format("%n%d%n",b);
        Integer c = Integer.valueOf("2");
        System.out.println(c);
    }
}
