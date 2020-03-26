package cn.how2j._02java中级._03集合框架._02其他集合._06Collections.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 练习 随机排列统计概率
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-26:13:23
 */
public class Shuffle {
    public static void main(String[] args) {
        // 初始化一个容器,存放10000个数据
        List<Integer> list = new ArrayList<>();

        // 给容器赋值
        int init = 10;
        for (int i = 0; i < init; i++) {
            list.add(i);
        }


        // 进行 指定次数的 双随机排列
        // 在混淆顺序的同时,进行统计次数
        int max = 1000 * 1000;
        int counter = 0;
        for (int i = 0; i < max; i++) {
            Collections.shuffle(list);
            if (
                    3 == list.get(0)
                    && 1 == list.get(1)
                    && 4 == list.get(2)
            ) {
                counter ++;
            }
        }

        // 进行计算概率
        double result = ((double) counter / (double) max);
        result *= 100;
        System.out.println(counter);
        System.out.println(result);
    }
}