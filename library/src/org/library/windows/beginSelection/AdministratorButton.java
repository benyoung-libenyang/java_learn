package org.library.windows.beginSelection;

import org.library.sys.Sys;
import org.library.windows.secondSelection.AdministratorUsing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorButton extends JPanel{
    public AdministratorButton(){

        setSize(300,100);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(new FlowLayout());

        int topMargin = 10; // 上间距大小
        int bottomMargin = 100; // 下间距大小
        setBorder(new EmptyBorder(topMargin, 0, bottomMargin, 0));

        JButton button = new JButton();//按钮样式
        button.setFont(new Font("微软雅黑",Font.BOLD,20));
        button.setContentAreaFilled(false);
        button.setText("我是管理员");

        button.setPreferredSize(new Dimension(300,100));
        button.setMinimumSize(new Dimension(300,50));

        button.addActionListener(new ActionListener() {//管理员的点击事件
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                // 创建账号和密码的输入字段
                JTextField textField1 = new JTextField(10);
                JTextField textField2 = new JTextField(10);
                // 将输入字段添加到面板中
                panel.add(new JLabel("请输入你的账号"));
                panel.add(textField1);
                panel.add(new JLabel("请输入你的密码"));
                panel.add(textField2);
                int option = JOptionPane.showOptionDialog(null, panel, "管理员登陆界面",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                String id = textField1.getText();
                String password = textField2.getText();

                /**
                 * 这里检验密码是否正确，还未实现，暂定为true
                 */
                boolean isPass = Sys.login(1,id,password);

                if (option == JOptionPane.OK_OPTION && isPass) {
                    new AdministratorUsing();
                }else if (option == JOptionPane.OK_OPTION && !isPass){
                    JOptionPane.showMessageDialog(null,//在哪个窗口弹出
                            "账号或密码不正确",//弹出的内容
                            "发生错误",//弹出的标题
                            JOptionPane.ERROR_MESSAGE);//弹出框的风格
                }

            }
        });

        add(button);
        setVisible(true);

    }
}
