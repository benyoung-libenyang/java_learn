package org.library.user;

import org.library.DatabaseConnector.DatabaseConnector;
import org.library.book.Book;

public class Admin {

    public String name;
    public int id;
    public String password;

    public Admin(String name, int id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    /**
     * 往数据库中添加用户
     * @param user
     */
    public void addUser(User user){
        DatabaseConnector.insert_user(user.id, user.name, user.password);
        System.out.println("添加用户"+user.name+"成功");
    }

    /**
     * 往数据库中添加书籍
     * @param book
     */
    public void addBook(Book book){
        DatabaseConnector.insert_book(book.bookName,book.author,book.ISBN,book.position, book.status);
        System.out.println("添加书籍" + book + "成功");
    }
}
