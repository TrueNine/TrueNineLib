package cn.how2j._02java中级._05lambda.聚合操作.Exercise;

import cn.how2j.Hero;
import cn.yzdz.random.RandomNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习 聚合操作
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-30:14:38
 */
public class Test {
    public static void main(String[] args) {
        // 初始化一个集合
        List<Hero> list = new ArrayList<>();
        int max = 20;
        for (int i = 0; i < max; i++) {
            list.add(new Hero("张三" + i,RandomNumber.randomInt(1000,true)));
        }

        // 进行筛选
        String name =
                list.stream()
                        .sorted((h1, h2) -> h1.hp >= h2.hp ? 1 : -1)
                        .skip(2)
                        .map(h -> h.name)
                        .findFirst()
                        .get();

        System.out.println(name);

        // 使用聚合打印列表
        list.stream()
                .sorted((c1,c2) -> c1.hp >= c2.hp ? 1 : -1)
                .forEach(h -> System.out.println(h.name + "|" + h.hp));
    }
}