package cn.how2j._06类和对象._02继承.Test;

/**
 * 类作用: 练习
 * 类说明: 练习继承
 *
 * @author 彭继工
 * @date 2020 - 03 - 01:12:20
 */
public class Armor extends Item {

    /** 护甲等级 */
    int ac;

    public static void main(String[] args) {
        Armor bujia = new Armor();
        bujia.name = "布甲";
        bujia.price = 300;
        bujia.ac = 15;

        Armor suozijia = new Armor();
        suozijia.name = "锁子甲";
        suozijia.price = 500;
        suozijia.ac = 40;

        System.out.println(bujia.name + bujia.price + bujia.ac);
        System.out.println(suozijia.name + suozijia.price + suozijia.ac);
    }
}

/**
 * 物品类
 */
class Item {
    /** 名称 */
    String name;
    /** 价格 */
    double price;
}