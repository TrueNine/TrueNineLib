package cn.how2j._01java初级._07接口与继承._03重写.Test;

/**
 * 类作用: 练习
 * 类说明: 练习重写
 *
 * @author 彭继工
 * @date 2020 - 03 - 06:13:03
 */
public class Test {
    public static void main(String[] args) {
        // 测试
        Item item = new Item();
        MagicPotion magicPotion = new MagicPotion();

        item.effect();
        magicPotion.effect();
    }
}

/**
 * 父类
 */
class Item {

    /**
     * 影响方法
     */
    public void effect() {
        System.out.println("只是一个物品,没有任何影响");
    }
}

/**
 * 蓝瓶类
 * 继承物品类,重写 effect 方法
 */
class MagicPotion extends Item {

    @Override
    public void effect() {
        System.out.println("这是蓝瓶,可以回蓝");
    }
}