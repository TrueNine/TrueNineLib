package cn.how2j._01面向对象._01类和对象.Test;

/**
 * 类作用: 设计物品类
 * 类说明: 类和对象练习
 *
 * @author 彭继工
 * @date 2020 - 02 - 22:9:35
 */
public class Test {
    public static void main(String[] args) {
        // 实例化物品
        Item item1 = new Item();
        item1.name = "血瓶";
        item1.price = 50.0f;

        Item item2 = new Item();
        item2.name = "草鞋";
        item2.price = 300.0f;

        Item item3 = new Item();
        item3.name = "长剑";
        item3.price = 350.0f;
    }
}

/**
 * 超出练习范围
 * 使用单独的类设计
 */
class Item {
    /** 物品名称 */
    String name;
    /** 物品价格,改用 double 类型 */
    double price;
}