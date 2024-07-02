package org.hydrakyoufeng.mj.user;

import org.hydrakyoufeng.mj.sys.SysController;

public class Guest extends User {

    public void ring(SysController sysController) {
        System.out.println("访客“" + getName() + "”按下门铃");
        sysController.setRingGuest(this);
    }
}
