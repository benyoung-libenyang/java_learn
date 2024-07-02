package org.library.windows.operationFinalMassage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoButtonBorrow extends JPanel{
    public static JFrameBorrowSuccessMassage jFrameBorrowSuccessMassage;
    public static void test(JFrameBorrowSuccessMassage tmp){
        jFrameBorrowSuccessMassage = tmp;
        return ;
    }
    public NoButtonBorrow(String information){
        JButton jButton = new JButton(information);
        jButton.setFont(new Font("宋体",Font.BOLD,15));

        setPreferredSize(new Dimension(150,100));
        setLayout(new GridLayout(1,1));

        jButton. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrameBorrowSuccessMassage.dispose();
            }
        });

        add(jButton);

        setVisible(true);
    }
}
