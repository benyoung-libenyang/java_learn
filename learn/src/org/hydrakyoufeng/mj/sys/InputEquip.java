package org.hydrakyoufeng.mj.sys;

import java.util.Scanner;

public class InputEquip {

    private String content;

    /**
     * 打开输入设备，让用户进行输入
     */
    public void input(String label) {
        if (label == null) {
            label = "请进行身份验证：";
        }
        System.out.println(label);
        Scanner scanner = new Scanner(System.in);
        content = scanner.nextLine();
    }

    /**
     * 获取输入内容
     * @return
     */
    public String getContent() {
        return content;
    }

}
