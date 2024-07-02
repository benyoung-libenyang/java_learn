package textbook;

public interface interface_1{
    //接口的成员变量

    //公共的静态常量， 可以通过interface_1.PI调用(多个接口出现相同命名的常量)
    public static final double PI = 3.14159246;
    //公共的抽象方法
    public abstract void in();

    //JDK8.0上
    //公共的默认方法, 类继承接口时可以直接调用也可以重写(省略default)
    public default void start(){
        System.out.println("输出");
    }
    //公共的静态方法, 只能由接口调用，不能由其他实现类进行
    public static void show(){
        System.out.println("公共的静态方法");
    }
    //私用方法, 主要就接口自己调用， 在默认方法和静态方法中的共同代码进行抽取
    private static void end(){

    }
}