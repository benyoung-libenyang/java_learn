package org.hydrakyoufeng.test.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {

    static {
        // 1: 注册驱动，整个项目只需要执行一次。
        // 注意：该驱动类是8.x版本jar包的驱动类。
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int insert(int id, String name, String password) {
        String sql = "insert into user(ID, NAME, PASSWORD) values (?, ?, ?) ";
        try ( // 2: 使用驱动管理器，根据连接地址，用户名，密码获取连接
              Connection conn = DriverManager.getConnection(
                      "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                      "benyoung", "1006");
              // 3: 使用预处理SQL获取执行器（预处理执行器）
              // 注意：开发中如果涉及到参数传递，必须使用预处理SQL，不能使用拼接字符串的方式来添加动态条件。
              PreparedStatement ps = conn.prepareStatement(sql);){
              ps.setInt(1, id);
              ps.setString(2,name);
              ps.setString(3,password);
              return ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        JDBC_test hj = new JDBC_test();
//        hj.insert("234567");
//        System.out.println(hj.queryList(null));
//        System.out.println(hj.queryList("123456"));
    }
}
