package cn.how2j._01java初级._07接口与继承._12综合练习.Test;

/**
 * 类作用: 练习
 * 类说明: 接口
 * 鱼
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:23:48
 */
public class Fish extends Animal implements Pet {

    /**
     * 私有的鱼名称
     */
    private String name;

    /**
     * 受保护的构造器
     * 初始化 legs 属性
     *
     */
    protected Fish() {
        super(0);
    }

    /**
     * 重写的方法
     * 表示鱼没有退
     */
    @Override
    public void walk() {
        System.out.println("鱼是没有腿的");
    }

    /**
     * 动物吃饭的方法
     */
    @Override
    public void eat() {
        System.out.println(this.name + "在吃粑粑");
    }

    /**
     * 查看宠物的名称
     *
     * @return 字符串
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 设置宠物的名称
     *
     * @param name 名称
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 宠物游游玩的方法
     */
    @Override
    public void play() {
        System.out.println("大声呐喊奥利给");
    }
}