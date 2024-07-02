package org.library.windows.secondSelection;

import org.library.windows.register.RegisterForBook;
import org.library.windows.register.RegisterForStudent;

import javax.swing.*;
import java.awt.*;

public class AdministratorUsing extends JFrame {
    public AdministratorUsing(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null); // 设置窗口居中对齐
        setLayout(new GridLayout(1,2,//1行2列
                5,5));//间距

        RegisterForBook registerForBook = new RegisterForBook();
        RegisterForStudent registerForStudent = new RegisterForStudent();
        add(registerForBook);
        add(registerForStudent);

        setVisible(true);
    }
}
