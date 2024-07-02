package org.library.windows.secondSelection;

import org.library.windows.thirdBorrowOrReturn.BookBorrowButton;
import org.library.windows.thirdBorrowOrReturn.BookReturnButton;

import javax.swing.*;
import java.awt.*;

public class StudentUsing extends JFrame{
    public StudentUsing(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null); // 设置窗口居中对齐
        setLayout(new GridLayout(1,2,//1行2列
                5,5));//间距

        BookBorrowButton bookBorrowButton = new BookBorrowButton();
        BookReturnButton bookReturnButton = new BookReturnButton();

        add(bookBorrowButton);
        add(bookReturnButton);

        setVisible(true);
    }
}
