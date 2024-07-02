package org.library.windows.operationFinalMassage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BookInformationFont extends JLabel {
    public BookInformationFont(String information){
        setFont(new Font("宋体",Font.BOLD,15));

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);

        setPreferredSize(new Dimension(200,200));

        Border border = BorderFactory.createLineBorder(Color.lightGray,5);
        setBorder(border);

        setText(information);
    }


    }
