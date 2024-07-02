package org.hydrakyoufeng.mj.validate;

/**
 * 胸牌信息比对器
 * @author zhiliaotang
 *
 */
public class CardValidate extends GenericeValidate {

    public CardValidate(Object[] inner, Object input) {
        super(inner, input);
    }

    @Override
    public boolean check() {
        if (this.getInner() == null || this.getInput() == null) {
            System.out.println("胸牌信息不完善");
            return false;
        }
        String inputStr;
        try {
            // 模拟胸牌信息采集：前2位模拟为标识使用什么方式校验
            inputStr = ((String) this.getInput()).substring(2);
        } catch (Exception e) {
            System.out.println("胸卡信息采集失败：" + e.getMessage());
            return false;
        }
        // 在系统内置信息中进行遍历比对
        for (int i = 0; i < this.getInner().length; i++) {
            if (inputStr.equals(this.getInner()[i])) {
                return true;
            }
        }
        return false;
    }

}
