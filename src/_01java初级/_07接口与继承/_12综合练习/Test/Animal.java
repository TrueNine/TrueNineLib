package _01java初级._07接口与继承._12综合练习.Test;

/**
 * 类作用: 练习
 * 类说明: 综合练习
 * Animal
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:23:29
 */
public abstract class Animal {
    /** 所有动物的腿 */
    protected int legs;

    /**
     * 受保护的构造器
     * 初始化 legs 属性
     * @param legs 动物腿的数量
     */
    protected Animal(int legs) {
        this.legs = legs;
    }

    /**
     * 动物吃饭的方法
     */
    abstract public void eat();

    /**
     * 动物如何行走
     * 打印行走的方式和腿的数目
     */
    public void walk() {
        System.out.println("腿的数量是: " + this.legs);
    }
}