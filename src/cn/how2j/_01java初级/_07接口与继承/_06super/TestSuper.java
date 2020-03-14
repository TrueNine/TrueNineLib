package cn.how2j._01java初级._07接口与继承._06super;

/**
 * 类作用: 测试
 * 类说明: 测试调用方法
 *
 * @author 彭继工
 * @date 2020 - 03 - 06:14:18
 */
public class TestSuper extends Item {

    TestSuper() {
        System.out.println("有东西经过");
        System.out.println("TestSuper.TestSuper");
    }

    public static void main(String[] args) {
        TestSuper testSuper = new TestSuper();
    }
}

class Item {
    Item(String name) {
        name = "34";
    }
    Item() {
        System.out.println("有东西经过");
        System.out.println("Item.Item");
    }
}