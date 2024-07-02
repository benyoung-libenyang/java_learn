package org.hydrakyoufeng.mj.sys;

public class Door {

    /**
     * 开门标识：0关闭（默认），1打开
     */
    private int openFlag;

    /**
     * 开门
     */
    public void open() {
        if (openFlag == 0) {
            openFlag = 1;
            System.out.println("门已经打开");
        } else {
            System.out.println("门已经是打开状态");
        }
    }

    /**
     * 关门
     */
    public void close() {
        if (openFlag == 1) {
            openFlag = 0;
            System.out.println("门已经关闭");
        }
    }

}
