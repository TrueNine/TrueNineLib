package cn.how2j._01java初级._07接口与继承._01接口;

import cn.how2j.Hero;

/**
 * 类作用: 测试
 * 类说明: 测试接口
 * 同时继承了 Hero ,实现了 MagicAttack
 *
 * @author 彭继工
 * @date 2020 - 03 - 05:15:32
 */
public class Inter extends Hero implements MagicAttack,PhysicalAttack {

    /**
     * 实现接口规定的方法
     */
    @Override
    public void magicAttack() {
        System.out.println(this.name + "进行了魔法攻击");
    }

    /**
     * 物理攻击方法
     */
    @Override
    public void physicalAttack() {
        System.out.println(this.name + "进行了物理攻击");
    }
}

/**
 * 魔法攻击接口
 */
interface MagicAttack {
    /** 魔法攻击 */
    void magicAttack();
}

/**
 * 物理攻击接口
 */
interface PhysicalAttack {
    /** 物理攻击方法 */
    void physicalAttack();
}