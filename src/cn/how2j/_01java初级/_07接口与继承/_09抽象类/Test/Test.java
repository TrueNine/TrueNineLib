package cn.how2j._01java初级._07接口与继承._09抽象类.Test;

/**
 * 类作用: 练习
 * 类说明: 练习抽象类
 * 设计一个抽象类
 * 继承了抽象类的方法,返回不同的 boolean 值
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:19:04
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Eggplant eggplant = new Eggplant();
        eggplant.disposable();
        computer.disposable();
    }
}

/**
 * 抽象类
 */
abstract class Item {
    /**
     * 实现该方法后
     * 返回一个是否可以消失的布尔值
     * @return 布尔值
     */
    public abstract boolean disposable();
}

class Computer extends Item {

    /**
     * 实现该方法后
     * 返回一个是否可以消失的布尔值
     *
     * @return 布尔值
     */
    @Override
    public boolean disposable() {
        System.out.println("此物品消失了");
        return false;
    }
}

class Eggplant extends Item {

    /**
     * 实现该方法后
     * 返回一个是否可以消失的布尔值
     *
     * @return 布尔值
     */
    @Override
    public boolean disposable() {
        System.out.println("Eggplant.disposable");
        System.out.println("茄子被吃了");
        return false;
    }
}