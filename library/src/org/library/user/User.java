package org.library.user;

import org.library.DatabaseConnector.DatabaseConnector;
import org.library.book.Book;
import org.library.sys.Sys;

public class User {

    public String name;
    public String id;

    public String password;


    public User(String name, String id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void borrowBook(Book book){
        System.out.println(book);
        System.out.println("确定要借吗？y/n");
        Sys.borrowBook(book);
        System.out.println(this.name + "借入了" + book.getBookName());

    }


    public void returnBook(String ISBN){
        System.out.println("请输入书的ISBN：");
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        System.out.println(ISBN);
        DatabaseConnector.update_book(ISBN, "1");
        System.out.println("还书完成");
    }

    public void checkRecord(){

    }

}
