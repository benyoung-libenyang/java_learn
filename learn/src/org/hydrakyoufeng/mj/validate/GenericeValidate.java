package org.hydrakyoufeng.mj.validate;

/**
 * 类使用implements实现接口，实现接口之后需要实现接口定义的抽象方法，除非自己是个抽象类
 * 抽象类可以有抽象方法，那么可以不实现接口的方法，交由子类去实现
 * @author zhiliaotang
 *
 */
public abstract class GenericeValidate implements IValidate {

    /**
     * 系统内的信息
     */
    private Object[] inner;

    /**
     * 用户输入信息
     */
    private Object input;

    public GenericeValidate(Object[] inner,Object input) {
        this.inner = inner;
        this.input = input;
    }

    /**
     * 获取系统内置信息
     * @return
     */
    public Object[] getInner() {
        return inner;
    }

    /**
     * 获取输入信息
     * @return
     */
    public Object getInput() {
        return input;
    }


}
