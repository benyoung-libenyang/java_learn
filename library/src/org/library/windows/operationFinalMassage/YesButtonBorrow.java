package org.library.windows.operationFinalMassage;

import org.library.book.Book;
import org.library.sys.Sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YesButtonBorrow extends JPanel {
    public YesButtonBorrow(String information, Book book){
        JButton jButton = new JButton(information);
        jButton.setFont(new Font("宋体",Font.BOLD,15));

        setPreferredSize(new Dimension(150,100));
        setLayout(new GridLayout(1,1));

        jButton. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * 这里是书籍位置
                 *
                 */
                Sys.getUser().borrowBook(book);
                String bookPosition = book.position;
                int result = JOptionPane.showConfirmDialog(null, "书籍位置为：" + bookPosition + "请自行借阅", "借书成功！", JOptionPane.YES_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        add(jButton);

        setVisible(true);
    }
}
