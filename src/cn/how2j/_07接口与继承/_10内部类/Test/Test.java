package cn.how2j._07接口与继承._10内部类.Test;

/**
 * 类作用: 练习
 * 类说明: 练习内部类
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:20:03
 */
public class Test {
    public static void main(String[] args) {
        // 直接当场实现
        Item item = new Item() {
            @Override
            public boolean disposable() {
                return false;
            }
        };
    }
}

/**
 * 抽象类
 * 从上个章节的练习复制的
 */
abstract class Item {
    /**
     * 实现该方法后
     * 返回一个是否可以消失的布尔值
     * @return 布尔值
     */
    public abstract boolean disposable();
}