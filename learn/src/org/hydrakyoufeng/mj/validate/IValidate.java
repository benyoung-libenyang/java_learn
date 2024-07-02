package org.hydrakyoufeng.mj.validate;

/**
 * 信息校验接口
 * @author zhiliaotang
 *
 */
public interface IValidate {

    /**
     * 接口定义的方法是抽象方法，没有具体实现，需要由实现的类去实现它。
     * 校验信息是否合法。
     * @return
     */
    boolean check();
}
