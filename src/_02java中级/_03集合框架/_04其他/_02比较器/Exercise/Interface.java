package _02java中级._03集合框架._04其他._02比较器.Exercise;

import cn.yzdz.random.RandomNumber;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-28:16:49
 */
public class Interface {
    public static void main(String[] args) {
        // 测试排序实现了 comparable 接口的类
        List<Item> list = new LinkedList<>();

        int max = 16;
        for (int i = 0; i < max; i++) {
            list.add(new Item("张三" + i, RandomNumber.randomInt(1,2000,true)));
        }

        // 直接进行排序
        Collections.sort(list);
        System.out.println(list);
    }
}

class Item implements Comparable<Item> {

    String name;
    double price;

    /**
     * 空构造器
     */
    Item() {

    }
    Item(String name,double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Item o) {
        if (this.price > o.price) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return this.name + "|" + this.price;
    }
}