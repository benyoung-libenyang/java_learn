package org.library.test;

import org.library.book.Book;
import org.library.user.Admin;

public class test {
    public static void main(String[] args) {
//        new Thread(() -> {
//            if(Sys.login(0, "12", "1007"))
//            Sys.getUser().borrowBook("bookName", "nihao");
//        }).start();
//
//        new Thread(() -> {
//            if(Sys.login(0, "123", "1006"))
//                Sys.getUser().borrowBook("bookName", "世界");
//        }).start();
//        User user = new User("123", "123", "34");
//        user.returnBook();
//        user.borrowBook("ISBN", "789456");
//        Map<String, Object> tmp = DatabaseConnector.search_user("123").get(0);
//        System.out.println(tmp);
//        String str = (String) tmp.get("id");
//        System.out.println("123".equals(str));
//        DatabaseConnector.update_book("123456", "benyoung");

        Admin admin = new Admin("jwh", 123450, "0000");
        Book book = new Book("果壳中的世界","JHW","789","E20321", "1");
        admin.addBook(book);

    }
}
