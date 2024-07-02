package org.library.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseConnector {

    static {
//        1、注册驱动
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * 增加
     */
    public static int insert_user(String id, String name, String password){
        String sql = "insert into user(id, name, PASSWORD) values (?, ?, ?)";

        try( // 2.使用驱动管理器，根据链接地址，用户名，密码获取链接
                Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                "library", "1006");
//          3.使用预处理SQL获取执行器
             PreparedStatement ps = conn.prepareStatement(sql);){
//            4.给预处理执行器添加参数
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, password);
//            5.正式提交执行（增删改查）， 返回受影响行数
            return ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static int insert_book(String bookName, String author, String ISBN, String position, String status){
        String sql = "insert into book(bookName, author, ISBN, position, STATUS) values (?, ?, ?, ?, ?)";

        try( // 2.使用驱动管理器，根据链接地址，用户名，密码获取链接
             Connection conn = DriverManager.getConnection(
                     "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                     "library", "1006");
//          3.使用预处理SQL获取执行器
             PreparedStatement ps = conn.prepareStatement(sql);){
//            4.给预处理执行器添加参数
            ps.setString(1, bookName);
            ps.setString(2, author);
            ps.setString(3, ISBN);
            ps.setString(4, position);
            ps.setString(5, status);
//            5.正式提交执行（增删改查）， 返回受影响行数
            return ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 查询数据库
     */
    public static List<Map<String, Object>> search_book(String type, String value){
        String sql = "SELECT * FROM book b where b." + type +"= ? ";
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        ArrayList<String> params = new ArrayList<>();
        params.add(value);
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                "library", "1006");
            PreparedStatement ps = conn.prepareStatement(sql);){
            for (var i = 0; i < params.size(); i++) {
                // 注意：SQL相关的索引从1开始
                ps.setObject(i + 1, params.get(i));
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (var i = 0; i < metaData.getColumnCount(); i++) {
                    row.put(metaData.getColumnLabel(i + 1), resultSet.getObject(i + 1));
                }
                resultList.add(row);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 查找用户
     * @param value
     * @return
     */
    public static List<Map<String, Object>> search_user(String value){
        String sql = "SELECT * FROM user b where b.id = ? ";
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        ArrayList<String> params = new ArrayList<>();
        params.add(value);
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                "library", "1006");
            PreparedStatement ps = conn.prepareStatement(sql);){
            for (var i = 0; i < params.size(); i++) {
                // 注意：SQL相关的索引从1开始
                ps.setObject(i + 1, params.get(i));
            }
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (var i = 0; i < metaData.getColumnCount(); i++) {
                    row.put(metaData.getColumnLabel(i + 1), resultSet.getObject(i + 1));
                }
                resultList.add(row);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 更新书籍信息
     */
    public static int update_book(String ISBN, String status){
        String sql = "update book set status = ? where ISBN = ?";

        try( // 2.使用驱动管理器，根据链接地址，用户名，密码获取链接
             Connection conn = DriverManager.getConnection(
                     "jdbc:mysql://127.0.0.1:3306/library?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull",
                     "library", "1006");
//          3.使用预处理SQL获取执行器
             PreparedStatement ps = conn.prepareStatement(sql);){
//            4.给预处理执行器添加参数
            ps.setString(1, status);
            ps.setString(2, ISBN);
//            5.正式提交执行（增删改查）， 返回受影响行数
            return ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
