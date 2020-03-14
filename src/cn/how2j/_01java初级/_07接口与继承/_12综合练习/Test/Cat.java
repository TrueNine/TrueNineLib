package cn.how2j._01java初级._07接口与继承._12综合练习.Test;

/**
 * 类作用:
 * 类说明:
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:23:42
 */
public class Cat extends Animal implements Pet {
    /**
     * 猫的名称
     */
    String name;

    /**
     * 受保护的构造器
     * 初始化 legs 属性
     * 根据 猫 的姓名初始化猫
     *
     * @param name 名称
     */
    protected Cat(String name) {
        super(4);
        this.name = name;
    }

    /**
     * 空构造器
     * 初始化猫的名称为 空字符串
     */
    protected Cat() {
        this("");
    }


    /**
     * 动物吃饭的方法
     */
    @Override
    public void eat() {
        System.out.println(this.name + "在吃奥利给");
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
        System.out.println(this.name + "在撤硕玩儿的不亦乐乎");
    }
}