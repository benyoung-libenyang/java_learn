package org.hydrakyoufeng.mj.user;

import java.util.Scanner;

import org.hydrakyoufeng.mj.sys.SysController;

/**
 * 管理员类
 *
 * @author zhiliaotang
 *
 */
public class Admin extends User {

    /**
     * 开门
     */
    public void openDoor(SysController sysController) {
        System.out.println("管理员“" + getName() + "”进行开门操作");
        sysController.setOpenSign(1);
    }

    /**
     * 处理访客按下门铃的操作
     *
     * @param guest
     */
    public void handleGuestRing(SysController sysController, Guest guest) {
        System.out.println("询问管理员：" + this.getName() + "，" + guest.getName() + "正在按下门铃，是否要进行开门？y/n");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if ("y".equals(str)) {
            openDoor(sysController);
        } else {
            System.out.println("管理员拒绝开门！");
        }

    }

    /**
     * 增加一组校验信息
     * @param sysController：系统控制器
     * @param type：类型，0密码，1胸牌，2指纹
     * @param value：信息值
     */
    public void insertValidate(SysController sysController,int type,String value) {
        System.out.println("管理员“" + getName() + "”开始录入信息。");
        sysController.addValidate(type, value);
    }

}
