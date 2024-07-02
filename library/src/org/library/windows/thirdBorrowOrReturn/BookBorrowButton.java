package org.library.windows.thirdBorrowOrReturn;

import org.library.book.Book;
import org.library.sys.Sys;
import org.library.windows.operationFinalMassage.JFrameBorrowSuccessMassage;
import org.library.windows.operationFinalMassage.NoButtonBorrow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookBorrowButton extends JButton {
    public BookBorrowButton(){
        setText("借阅书籍");
        setFont(new Font("微软雅黑",Font.BOLD,20));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel panel = new JPanel();
                JTextField textField1 = new JTextField(10);
                panel.add(new JLabel("请输入你要借阅的书籍名称"));
                panel.add(textField1);
                int option = JOptionPane.showOptionDialog(null, panel, "书籍借阅界面",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                String bookName = textField1.getText();//学生想要借阅的书籍名称
                Book book = Sys.checkBook("bookName", bookName);

                /**
                 * 这里检验库中是否还有此书籍，默认为true
                 */
                boolean isPass = true;

                if (option == JOptionPane.OK_OPTION && isPass) {
                    //输出该书的信息
                    JFrameBorrowSuccessMassage JFrameBorrowSuccessMassage = new JFrameBorrowSuccessMassage(book);
                    NoButtonBorrow.test(JFrameBorrowSuccessMassage);
                }else if (option == JOptionPane.OK_OPTION && !isPass){
                    JOptionPane.showMessageDialog(null,
                            "该书还未收录或已被借走",//弹出的内容
                            "抱歉",//弹出的标题
                            JOptionPane.WARNING_MESSAGE);//弹出框的风格
                }



            }
        });
    }
}
