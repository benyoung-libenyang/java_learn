package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        //java.sql包中的DriverManager类有两个建立连接的类的方法（static）
        //Connection getConnection(String, string)
        //Connection getCOnnection(String)
        Connection con;
//        useSSL,有汉字：characterEncoding
        String uri = "jdbc:mysql://127.0.0.1:3306/students?user=root&password=1006&useSSL=true&characterEncoding=utf-8";
        try{
            con = DriverManager.getConnection(uri);
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            使用Statement声明一个SQL语句对象
            Statement sql = con.createStatement();
//            sql执行sql语句，并且将查询结果放在一个ResultSet类的对象中。
            ResultSet rs = sql.executeQuery("SELECT * FROM student");
            System.out.println("id"+"\t"+"name"+"\t"+"cardid"+"\t"+"classs");
            while(rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String cardid = rs.getString(3);
                String classs = rs.getString(4);
                System.out.println(id+"\t"+name+"\t"+cardid+"\t\t"+classs);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
