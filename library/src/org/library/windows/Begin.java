package org.library.windows;

import org.library.windows.beginSelection.AdministratorButton;
import org.library.windows.beginSelection.StudentButton;

import javax.swing.*;
import java.awt.*;

public class Begin extends JFrame {
    public Begin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null); // 设置窗口居中对齐

        Container beginWindow = getContentPane();
        beginWindow.setLayout(new BoxLayout(beginWindow, BoxLayout.Y_AXIS));

        BeginTitle beginTitle = new BeginTitle();
        AdministratorButton administratorButton = new AdministratorButton();
        StudentButton studentButton = new StudentButton();

        beginWindow.add(beginTitle);
        beginWindow.add(studentButton);
        beginWindow.add(administratorButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Begin();
    }
}
