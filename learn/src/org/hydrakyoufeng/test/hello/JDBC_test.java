package org.hydrakyoufeng.test.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC_test {

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

    /**
     * 查询列表
     */
    public List<Map<String, Object>> queryList(String password) {
        String sql = "SELECT * FROM t_password p where p.status = 1 ";
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        ArrayList<String> params = new ArrayList<>();
        if (null != password && !password.equals("")) {
            sql += " AND p.PASSWORD = ? ";
            params.add(password);
        }

        // try()：1.8新语法，Autoclose，如果实现了AutoClose接口的类，可以定义在try()的括号内，无论是否发生异常，最终会自动关闭。
        try ( // 2: 使用驱动管理器，根据连接地址，用户名，密码获取连接
              Connection conn = DriverManager.getConnection(
                      "jdbc:mysql://127.0.0.1:3306/entrance?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                      "entrance", "1006");
              // 3: 使用预处理SQL获取执行器（预处理执行器）
              // 注意：开发中如果涉及到参数传递，必须使用预处理SQL，不能使用拼接字符串的方式来添加动态条件。
              PreparedStatement ps = conn.prepareStatement(sql);) {
            // 4：给预处理执行器添加，添加参数
            for (var i = 0; i < params.size(); i++) {
                // 注意：SQL相关的索引从1开始
                ps.setObject(i + 1, params.get(i));
            }
            // 5：正式提交执行（查询语句），获取结果集
            ResultSet resultSet = ps.executeQuery();
            // 6: 处理结果集，最万能的方式是通过结果集模型来处理结果集
            // 获取结果集模型，包含列数，每一列的列名、数据类型……
            ResultSetMetaData metaData = resultSet.getMetaData();
            // resultSet.next()：将指针下移一位，如果没有新的数据行，返回false。
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (var i = 0; i < metaData.getColumnCount(); i++) {
                    row.put(metaData.getColumnLabel(i + 1), resultSet.getObject(i + 1));
                }
                resultList.add(row);
            }
            // 7: 关闭执行器，关闭连接（已经通过try/catch新语法完成了关闭）
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 增加语句
     * @param password
     * @return
     */
    public int insert(int id, String name, String password) {
        String sql = "insert into user (id, name, PASSWORD) values (?, ?, ?) ";

        // try()：1.8新语法，Autoclose，如果实现了AutoClose接口的类，可以定义在try()的括号内，无论是否发生异常，最终会自动关闭。
        try ( // 2: 使用驱动管理器，根据连接地址，用户名，密码获取连接
              Connection conn = DriverManager.getConnection(
                      "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                      "library", "1006");
              // 3: 使用预处理SQL获取执行器（预处理执行器）
              // 注意：开发中如果涉及到参数传递，必须使用预处理SQL，不能使用拼接字符串的方式来添加动态条件。
              PreparedStatement ps = conn.prepareStatement(sql);) {
            // 4：给预处理执行器添加，添加参数
            ps.setInt(1, id);
            ps.setString(2,name);
            ps.setString(3,password);
            // 5：正式提交执行（增、删、改），返回受影响行数
            return ps.executeUpdate();
            // 6: 关闭执行器，关闭连接（已经通过try/catch新语法完成了关闭）
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        JDBC_test hj = new JDBC_test();
//        hj.insert(12,"benyoung","1007");
//        System.out.println(hj.queryList(null));
        System.out.println(hj.queryList("2347"));
    }
}
