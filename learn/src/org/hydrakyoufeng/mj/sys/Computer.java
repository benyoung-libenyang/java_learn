package org.hydrakyoufeng.mj.sys;

import com.mysql.cj.AbstractQuery;
import org.hydrakyoufeng.mj.validate.CardValidate;
import org.hydrakyoufeng.mj.validate.FingerValidate;
import org.hydrakyoufeng.mj.validate.IValidate;
import org.hydrakyoufeng.mj.validate.PassValidate;

/**
 * 门禁系统计算器，用于校验用户的输入是否合法
 *
 * @author zhiliaotang
 *
 */
public class Computer {
    private String[] passWord = new String[100]; // 计算机存储的雇员密码，数字字符串

    private String[] card = new String[100]; // 计算机存储的雇员胸卡号，字符串形式

    private String[] fingerMark = new String[100]; // 计算机存储的雇员指纹，字符串形式

    /**
     * 验证
     * @return
     */
    public boolean validate(String passStr){
        IValidate validate = null;
        String prefix = passStr.substring(0, 2);
        /*验证密码*/
        if(prefix.equals("pa")){
            validate = new PassValidate(passWord,passStr);
            return validate.check();
        }
        /*验证胸卡*/
        else if(prefix.equals("cd")){
            validate = new CardValidate(card,passStr);
            return validate.check();
        }
        /*验证指纹*/
        else if(prefix.equals("fg")) {
            validate = new FingerValidate(fingerMark,passStr);
            return validate.check();
        } else {
            return false;
        }
    }

    /**
     * 增加新胸卡
     * @param fingerMark
     */
    public void addCard(String card) {
        for(int i=0;i<100;i++){
            if(this.card[i]==null){
                this.card[i] = card;
                return;
            }
        }
    }

    /**
     * 增加新指纹
     * @param fingerMark
     */
    public void addFingerMark(String fingerMark) {
        for(int i=0;i<100;i++){
            if(this.fingerMark[i]==null){
                this.fingerMark[i] = fingerMark;
                return;
            }
        }
    }

    /**
     * 增加新密码
     * @param passWord
     */
    public void addPassWord(int passWord) {
        for(int i=0;i<100;i++){
            if(this.passWord[i]==null){
                this.passWord[i] = passWord*2+"";
                return;
            }
        }
    }

}
