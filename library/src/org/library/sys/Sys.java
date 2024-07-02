package org.library.sys;

import org.library.DatabaseConnector.DatabaseConnector;
import org.library.book.Book;
import org.library.user.User;

import java.util.List;
import java.util.Map;

public class Sys {

    /**
     * 当前系统的用户
     */
    private static User user;

    /***
     * 借书， 还需要修改数据库
     * @param book
     */
    public static void borrowBook(Book book){
        DatabaseConnector.update_book(book.ISBN, user.name);
        System.out.println("更新了书籍在数据库中的信息");
        return ;
    }

    /***
     * 添加数据库查询书籍
     * @param type
     * @param value
     * @return Book
     */
    public static Book checkBook(String type, String value){
        Map<String, Object> tmp = DatabaseConnector.search_book(type, value).get(0);
        Book book = new Book((String) tmp.get("bookName"),(String) tmp.get("author"),(String) tmp.get("ISBN"),(String) tmp.get("position"),(String) tmp.get("STATUS"));
        System.out.println("查询书籍信息："+ book);
        return book;
    }

    /**
     * 登录类型
     * 0：user
     * 1：admin
     * @param type
     * @return
     */
    public static boolean login(int type, String id, String password){
        System.out.println("请输入用户id");
        System.out.println(id);
        List<Map<String, Object>> tmp_list = DatabaseConnector.search_user(id);
        if(tmp_list.size() == 0){
            System.out.println("无该用户");
            return false;
        }
        Map<String, Object> tmp = tmp_list.get(0);
        if(id.equals(tmp.get("id"))){
            System.out.println("用户查询成功，请输入密码：");
            System.out.println(password);
            if(password.equals(tmp.get("PASSWORD"))){
                user = new User((String) tmp.get("name"), id, password);
                System.out.println("登录成功");
                return true;
            }else{
                System.out.println("密码错误");
                return false;
            }
        }else {
            System.out.println("无该用户，请联系管理员添加");
            return false;
        }
    }

    public static User getUser(){
        return user;
    }

    /**
     *
     */

}
