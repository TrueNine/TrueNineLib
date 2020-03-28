package cn.how2j._02java中级._03集合框架._04其他._02比较器.Exercise;

import cn.how2j.Hero;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 自定义顺序排序 TreeSet
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-28:16:44
 */
public class TreeSetSort {
    public static void main(String[] args) {
        // 在构造器中传入 Comparator
        // 进行当场实现
        Set<Hero> set = new TreeSet<>(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (o1.hp > o2.hp) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        // 测试存入数据
        set.add(new Hero("张三",20));
        set.add(new Hero("李四",30));
        set.add(new Hero("王五",50));

        // 查看顺序
        System.out.println(set.toString());
    }
}