package cn.how2j._02java中级._03集合框架._01ArrayList._05遍历.Exercise;

import cn.how2j.Hero;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 练习 遍历删除元素
 *
 * @author 彭继工
 * @date 2020-03-22:12:47
 */
public class Each {
    public static void main(String[] args) {
        // 创建一个 list 然后初始化
        List<Hero> list = new ArrayList<>();

        // 初始化元素
        int size = 100;
        for (int i = 0; i < size; i++) {
            list.add(new Hero("hero" + i,i >> 2));
        }

        // 不能使用普通的 for 比遍历,因为是会动的
        List<Hero> removeList = new ArrayList<>();
        for (Hero temp : list) {
            // 如果是第一个则不处理
            if (0 == Integer.parseInt(temp.name.substring(4)) % 8
                    && (0 == Integer.parseInt(temp.name.substring(4)) % 8)) {
                removeList.add(temp);
            }
        }
        // 然后逐个删除
        for (Hero temp : removeList) {
            boolean is = list.remove(temp);
        }

        // 遍历剩下的元素,炫技
        for (Iterator<Hero> it = list.iterator();
                it.hasNext();) {
            Hero h = it.next();
            System.out.println(h.name);
        }
    }
}