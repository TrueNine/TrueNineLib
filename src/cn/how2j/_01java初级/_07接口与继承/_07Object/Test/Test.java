package cn.how2j._01java初级._07接口与继承._07Object.Test;

import cn.how2j.Item;

/**
 * 类作用: 练习
 * 类说明: 练习 重写 Object 方法
 *
 * @author 彭继工
 * @date 2020 - 03 - 06:15:56
 */
public class Test {
    public static void main(String[] args) {
        // 写在了工具类,测试
        Item computer = new Item("华硕",23);
        Item computer2 = new Item("华硕",23);
        Item computer3 = new Item("华为",1);

        System.out.println(computer3);
        System.out.println(computer.equals(computer2));
        System.out.println(computer.equals(computer3));
    }
}