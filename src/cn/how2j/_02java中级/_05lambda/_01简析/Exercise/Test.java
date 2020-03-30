package cn.how2j._02java中级._05lambda._01简析.Exercise;

import cn.how2j.Hero;
import cn.yzdz.random.RandomNumber;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 练习 lambda
 * 简写 Comparator
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-29:14:46
 */
public class Test {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // 初始化一个集合
        List<Hero> list = new LinkedList<>();
        int max = 20;
        for (int i = 0; i < max; i++) {
            list.add(new Hero("张三", RandomNumber.randomInt(100,true)));
        }

        // 第一种方式
        Comparator<Hero> c1 = (Hero h1,Hero h2) -> {
            return h1.hp >= h2.hp ? 1 : -1;
        };

        // 第二种方式,去掉return 和 {}
        Comparator<Hero> c2 = (Hero h1,Hero h2) -> h1.hp >= h2.hp ? 1 : -1;


        // 进行排序,实现 Comparator
        list.sort(c2);

        // 直接传入 lambda
        list.sort((h1,h2) -> h1.hp >= h2.hp ? 1 : -1);

        System.out.println(list);
    }
}