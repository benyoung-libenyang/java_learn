package org.library.windows.thirdBorrowOrReturn;

import org.library.book.Book;
import org.library.sys.Sys;
import org.library.windows.operationFinalMassage.JFrameReturnSuccessMassage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookReturnButton extends JButton {
    public BookReturnButton(){
        setText("归还书籍");
        setFont(new Font("微软雅黑",Font.BOLD,20));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel panel = new JPanel();
                JTextField textField1 = new JTextField(10);
                panel.add(new JLabel("请输入你要归还的书籍的ISBN"));
                panel.add(textField1);
                int option = JOptionPane.showOptionDialog(null, panel, "书籍归还界面",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                String ISBN = textField1.getText();//学生想要归还的书籍的ISBN


                /**
                 * 这里检验库中是否还有此书籍，默认为true
                 * "1"  : 还在库中
                 * "benyoung"： 被借走
                 */
                boolean borrowed = true;
                Book book  = Sys.checkBook("ISBN", ISBN);
                if ("1".equals(book.status))
                    borrowed = false;

                if (option == JOptionPane.OK_OPTION && borrowed) {
                    //输出该书的信息
                    JFrameReturnSuccessMassage JFrameReturnSuccessMassage = new JFrameReturnSuccessMassage(book);

                }else if (option == JOptionPane.OK_OPTION && !borrowed){
                    JOptionPane.showMessageDialog(null,
                            "该书已被归还！请检查书籍名称是否错误",//弹出的内容
                            "抱歉",//弹出的标题
                            JOptionPane.WARNING_MESSAGE);//弹出框的风格
                }



            }
        });
    }
}
