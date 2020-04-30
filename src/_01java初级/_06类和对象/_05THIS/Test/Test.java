package _01java初级._06类和对象._05THIS.Test;

import cn.how2j.Hero;

/**
 * 类作用: 练习
 * 类说明: 直接使用了设计好的工具类
 *
 * @author 彭继工
 * @date 2020 - 03 - 03:11:57
 */
public class Test {
    public static void main(String[] args) {
        // 尝试调用构造器
        Hero hero = new Hero("老八",20,2,2);
        System.out.println(hero);
    }
}
