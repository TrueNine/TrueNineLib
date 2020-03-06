package cn.how2j._07接口与继承._04多态.Test;

import cn.how2j.Hero;
import cn.how2j.Mortal;

/**
 * 类作用: 练习
 * 类说明: 练习多态
 *
 * @author 彭继工
 * @date 2020 - 03 - 06:13:20
 */
public class Test {
    public static void main(String[] args) {
        // 已经写在了工具类内,进行测试
        Hero test = new Hero("盖伦",300);
        AdApHero adApHero = new AdApHero();
        ApHero apHero = new ApHero();
        AdHero adHero = new AdHero();

        test.kill(adApHero);
        test.kill(adHero);
        test.kill(apHero);
    }
}

class AdHero extends Hero implements Mortal {

    /**
     * 空方法
     * 不知道用起来干什么的
     * 具体就是打印一句话
     */
    @Override
    public void die() {
        System.out.println(this.name + "AD英雄死了");
    }
}

class ApHero extends Hero implements Mortal {

    /**
     * 空方法
     * 不知道用起来干什么的
     * 具体就是打印一句话
     */
    @Override
    public void die() {
        System.out.println(this.name + "AP英雄死了");
    }
}

class AdApHero extends Hero implements Mortal {

    /**
     * 空方法
     * 不知道用起来干什么的
     * 具体就是打印一句话
     */
    @Override
    public void die() {
        System.out.println(this.name + "混合英雄死了");
    }
}