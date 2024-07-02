package org.library.windows.operationFinalMassage;

import org.library.book.Book;

import javax.swing.*;
import java.awt.*;

public class JFrameReturnSuccessMassage extends JFrame {
    public JFrameReturnSuccessMassage(Book book){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 560);
        setResizable(false);//禁止更改窗口大小
        setLocationRelativeTo(null); // 设置窗口居中对齐
        setTitle("已查阅到该书本信息！");

        setLayout(new FlowLayout());

        JLabel label1 = new BookInformationFont("书籍名称");
        JLabel label2 = new BookInformationFont("书籍作者");
        JLabel label3 = new BookInformationFont("ISBN");
        JLabel label4 = new BookInformationFont("书籍位置");
        JLabel label5 = new BookInformationFont("书籍是否在库中");

        JLabel label6 = new BookInformationFont(book.bookName);
        JLabel label7 = new BookInformationFont(book.author);
        JLabel label8 = new BookInformationFont(book.ISBN);
        JLabel label9 = new BookInformationFont(book.position);
        String str ;
        if("1".equals(book.status))
            str = "是";
        else
            str = book.bookName + "被" + book.status + "借走了";
        JLabel label10 = new BookInformationFont(str);

        YesButtonReturn yes = new YesButtonReturn("我要归还该书", book);
        NoButtonBorrow no = new NoButtonBorrow("我再想想");

        add(label1);add(label2);add(label3);add(label4);add(label5);
        add(label6);add(label7);add(label8);add(label9);add(label10);
        add(yes);
        add(no);


        setVisible(true);
    }
}
