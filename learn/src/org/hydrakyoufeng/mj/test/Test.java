package org.hydrakyoufeng.mj.test;

import java.util.Scanner;

import org.hydrakyoufeng.mj.sys.Computer;
import org.hydrakyoufeng.mj.sys.Door;
import org.hydrakyoufeng.mj.sys.InputEquip;
import org.hydrakyoufeng.mj.sys.SysController;
import org.hydrakyoufeng.mj.user.Admin;
import org.hydrakyoufeng.mj.user.Employee;
import org.hydrakyoufeng.mj.user.Guest;

public class Test {

    public static void main(String[] args) {


        Admin admin = new Admin();
        admin.setName("奉先");

        Door door = new Door();
        InputEquip inputEquip = new InputEquip();
        Computer computer = new Computer();
        SysController sysController = new SysController(door, inputEquip,computer);

        sysController.regist(admin);

        // 访客
        Guest guest = new Guest();
        guest.setName("访客1");

        // 职员
        Employee employee = new Employee();
        employee.setName("职员1");

        // 线程1：启动系统控制器工作
        new Thread(() -> {
            sysController.work();
        }).start();


        // 线程2：模拟管理员的操作
        // 管理员的操作与系统工作异步进行
        new Thread(() -> {
            System.out.println("模拟管理员开门、访客按门铃线程启动。");
//            System.out.println("Y：管理员开门，g：访客按门铃，e：职员认证。i：管理员添加校验信息");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    // 线程休息1000毫秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                System.out.println("Y：管理员开门，g：访客按门铃，e：职员认证。i：管理员添加校验信息");
                String str = scanner.nextLine();
                if ("Y".equals(str)) {
                    admin.openDoor(sysController);
                } else if ("g".equals(str)) {
                    guest.ring(sysController);
                } else if ("e".equals(str)) {
                    employee.inputPass(sysController);
                } else if ("i".equals(str)) {
                    System.out.println("录入验证信息，1录入胸牌，2录入指纹，3录入密码");
                    // 调用sys中添加验证消息的函数
                    Scanner scanner_type = new Scanner(System.in);
                    int type = scanner_type.nextInt();
                    System.out.println("请输入value");
                    Scanner scanner_value = new Scanner(System.in);
                    String value = scanner_value.nextLine();
                    sysController.addValidate(type, value);
                } else if ("exit".equals(str)) {
                    System.out.println("系统下线");
                    break;
                }
            }
        }).start();
    }
}
