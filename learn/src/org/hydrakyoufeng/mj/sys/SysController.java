package org.hydrakyoufeng.mj.sys;

import org.hydrakyoufeng.mj.user.Admin;
import org.hydrakyoufeng.mj.user.Guest;

/**
 * 系统控制类
 *
 * @author zhiliaotang
 *
 */
public class SysController {

    /**
     * 门
     */
    private Door door;

    /**
     * 输入设备
     */
    private InputEquip inputEquip;

    /**
     * 门禁计算器
     */
    private Computer computer;

    /**
     * 获取输入设备
     * @return
     */
    public InputEquip getInputEquip() {
        return inputEquip;
    }

    /**
     * 按门铃的访客 扩展任务1：如果多个人同时按门铃如何处理？
     * 扩展任务2：如何让有人按了门铃之后，立刻通知管理员？多线程的数据同步，可以考虑阻塞队列。也可以自己使用线程同步的方法处理。
     */
    private Guest ringGuest;

    /**
     * 允许注册10个管理员
     */
    private Admin[] registedAdmin = new Admin[10];

    /**
     * 门的打开/关闭信号 0: 关闭，1：打开
     */
    private int openSign = 0;

    public SysController(Door door, InputEquip inputEquip,Computer computer) {
        this.door = door;
        this.inputEquip = inputEquip;
        this.computer = computer;
        System.out.println("欢迎使用门禁系统v0.0.1！");
    }

    /**
     * 注册管理员，以通知有人按下门铃
     *
     * @param admin
     */
    public void regist(Admin admin) {
        // 循环：如果有空余位置，注册管理员
        for (int i = 0; i < registedAdmin.length; i++) {
            if (registedAdmin[i] == null) {
                registedAdmin[i] = admin;
                break;
            }
        }
    }

    /**
     * 设置开门信号：通过管理员设置门打开或关闭的信号
     *
     * @param openSign
     */
    public void setOpenSign(int openSign) {
        this.openSign = openSign;
    }

    /**
     * 提供访客按门铃的操作，记录访客信息
     *
     * @param guest
     */
    public void setRingGuest(Guest guest) {
        this.ringGuest = guest;
    }

    /**
     * 门禁系统的工作流程 1：判断开门标识，是否已经打开，如果是打开标识，那么将门打开。
     */
    public void work() {
        System.out.println("门禁系统开始工作");
        while (true) {
            try {
                // 睡眠1000毫秒，模拟门禁正常工作时的时间消耗
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            handleOpenSign();
            fireAdmin();
        }
    }

    /**
     * 处理开门标识
     */
    private void handleOpenSign() {
        // 判断管理员是否发起了开门操作
        if (openSign == 1) {
            // 设置关门标识
            openSign = 0;
            door.open();
            // 让线程睡眠5000毫秒（代码会阻塞）
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            door.close();
        }
    }

    /**
     * 通知注册了的管理员，有访客按下了门铃。
     */
    private void fireAdmin() {
        // 如果有人按下门铃的操作
        // 扩展任务1：如何处理同一时间，多个客人按下门铃。（多线程）
        // 扩展任务2：如果不使用轮询，如何立刻侦听到有客人按下门铃。（触发器）
        if (this.ringGuest != null) {
            var ringGuest = this.ringGuest;
            this.ringGuest = null;
            System.out.println("有人按下了门铃，通知管理员是否开门：");
            for (int i = 0; i < registedAdmin.length; i++) {
                if (registedAdmin[i] != null) {
                    registedAdmin[i].handleGuestRing(this, ringGuest);
                }
            }
        }
    }

    public void addValidate(int type,String value) {
        if (type == 1) {
            computer.addCard(value);
            System.out.println("添加胸牌信息成功");
        } else if (type == 2) {
            computer.addFingerMark(value);
            System.out.println("添加指纹信息成功");
        } else {
            computer.addPassWord(Integer.parseInt(value));
            System.out.println("添加密码信息成功");
        }
    }

    public void check(String value){
        if(computer.validate(value)){
            System.out.println("身份验证成功马上开门");
            this.openSign = 1;
        }else{
            System.out.println("错误，请重新输入");
        }
    }

}
