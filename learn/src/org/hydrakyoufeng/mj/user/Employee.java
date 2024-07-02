package org.hydrakyoufeng.mj.user;

import org.hydrakyoufeng.mj.sys.SysController;

public class Employee extends User {

    /**
     * 使用系统控制器打开输入设备，进行密码输入
     */
    public void inputPass(SysController sysController) {
        System.out.println("职员1准备输入身份校验信息。");
        // 打开输入设备输入信息
        sysController.getInputEquip().input(null);

        // 获取用户输入内容
        // 用户输入pa开头，表示密码比对，用户输入cd开头，表示胸牌比对，用户输入fg开头表示指纹比对
        // 实例：pa123456，cd223344，fg334455
        sysController.check(sysController.getInputEquip().getContent());
        // 如果比对正确，那么使用新系统控制器开门

    }

}
