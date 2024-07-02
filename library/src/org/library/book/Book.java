package org.library.book;

public class Book {

    public String bookName;
    public String author;
    public String ISBN;
    public String position;
    
    public String status;

    public Book(String bookName, String author, String ISBN, String position, String status){
        this.bookName = bookName;
        this.author = author;
        this.ISBN = ISBN;
        this.position = position;
        this.status = status;
    }

//    重写类的输出方法
    @Override
    public String toString() {
        return "书名：" + this.bookName + " " + "作者：" + this.author
                + " " + "ISBN:" + this.ISBN +" " + "位置：" + this.position;
    }

//    获取书籍的名称
    public String getBookName(){
        return this.bookName;
    }
}
