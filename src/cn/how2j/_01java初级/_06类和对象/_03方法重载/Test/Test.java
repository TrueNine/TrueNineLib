package cn.how2j._01java初级._06类和对象._03方法重载.Test;

import cn.how2j.Hero;

/**
 * 类作用: 练习
 * 类说明: 测试方法重载
 *
 * @author 彭继工
 * @date 2020 - 03 - 01:12:28
 */
public class Test {
    public static void main(String[] args) {
        // 测试
        Hero hero = new Hero();
        hero.name = "张三";

        Support support = new Support();
        support.name = "李四";

        // 测试重载方法
        support.heal();
        support.heal(hero);
        support.heal(hero,300);
    }
}

/**
 * 继承了英雄类的辅助英雄类
 * 测试重写方法
 * 在原来的基础上增加:
 * 治疗方法
 */
class Support extends Hero {

    /**
     * 治疗空方法
     */
    public void heal() {
        System.out.println("治疗的空方法");
    }

    /**
     * 治疗方法
     * 为指定的英雄加血
     *
     * @param hero 指定的英雄
     */
    public void heal(Hero hero) {
        System.out.println("为英雄: " + hero.name + " 加血");
    }

    /**
     * 治疗方法
     * 为指定的英雄加 指定的 hp
     *
     * @param hero 指定的英雄
     * @param hp 指定的血量
     */
    public void heal(Hero hero,int hp) {
        System.out.println("为英雄: " + hero.name + " 加了: " + hp + " 的血");
    }
}