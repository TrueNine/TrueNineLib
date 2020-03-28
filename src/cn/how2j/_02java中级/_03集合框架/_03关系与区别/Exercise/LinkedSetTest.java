package cn.how2j._02java中级._03集合框架._03关系与区别.Exercise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 练习
 * 打印 Math.PI的内容
 * 打印不重复的内容
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-28:13:23
 */
public class LinkedSetTest {
    public static void main(String[] args) {
        // 获取 Math.PI,并进行转换
        String str = String.valueOf(Math.PI);
        System.out.println(str);

        // 转换为 char 数组
        char[] cs = str.toCharArray();

        // 存入 LinkedSet
        Set<Character> set = new LinkedHashSet<>();

        // 开始添加,如果碰到重复会直接去掉重复
        for (int i = 0; i < cs.length; i++) {
            set.add(cs[i]);
        }

        // 测试
        System.out.println(set.toString());
    }
}