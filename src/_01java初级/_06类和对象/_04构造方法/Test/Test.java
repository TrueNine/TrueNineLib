package _01java初级._06类和对象._04构造方法.Test;

        import cn.how2j.Hero;

/**
 * 类作用: 练习
 * 类说明: 因为在工具类内已经设计好
 * 所以不重复写一遍
 *
 * @author 彭继工
 * @date 2020 - 03 - 02:17:39
 */
public class Test {
    public static void main(String[] args) {

        // 测试书写完成的工具类
        Hero hero = new Hero("老八",20,33,24);
        Hero hero1 = new Hero("李四",23,23,23);

        System.out.println(hero);
        System.out.println(hero1);
    }
}