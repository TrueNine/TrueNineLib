package _02java中级._03集合框架._02其他集合._03HashSet.Exercise;

import cn.yzdz.random.RandomString;

import java.util.HashSet;
import java.util.Set;

/**
 * 练习 生成一百组随机字符(2个一组)
 * 找出重复的种类
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-25:16:58
 */
public class RandomTwo {
    public static void main(String[] args) {
        String[] ss = new String[1000000];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < ss.length; i++) {
            ss[i] = new RandomString().numberAndLetter(10);
        }
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i] + "\t");
            if (0 == (i % 9)) {
                System.out.println();
            }
        }

        // 判断种类
        for (String tempW : ss) {
            int counter = 0;
            for (String tempN : ss) {
                if (tempW.equalsIgnoreCase(tempN)) {
                    counter ++;
                }
                if (counter >= 2) {
                    counter = 0;
                    set.add(tempN);
                }
            }
        }

        // 打印重复的种类
        System.out.println(set.toString());
    }
}