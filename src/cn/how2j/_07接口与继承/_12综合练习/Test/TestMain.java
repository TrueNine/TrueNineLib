package cn.how2j._07接口与继承._12综合练习.Test;

/**
 * 类作用: 测试类
 * 类说明: 测试所有的类
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:23:59
 */
public class TestMain {
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.eat();
        spider.walk();

        Cat cat = new Cat();
        cat.eat();
        cat.setName("tom");
        System.out.println(cat.getName());
        cat.play();
        cat.walk();

        Fish fish = new Fish();
        fish.setName("老八");
        fish.eat();
        fish.play();
        System.out.println(fish.getName());
        fish.walk();
    }
}
