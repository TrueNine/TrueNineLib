package cn.how2j._01java初级._07接口与继承._12综合练习.Test;

/**
 * 类作用:
 * 类说明:
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:23:36
 */
public class Spider extends Animal {
    /**
     * 受保护的构造器
     * 初始化 legs 属性
     *
     */
    protected Spider() {
        super(8);
    }

    /**
     * 动物吃饭的方法
     */
    @Override
    public void eat() {
        System.out.println("蜘蛛吃人");
    }
}