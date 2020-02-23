package cn.how2j._03操作符._02关系运算符.Test;

import java.util.Scanner;

/**
 * 类作用: 练习
 * 类说明: 练习关系运算符
 *
 * @author 彭继工
 * @date 2020 - 02 - 24:8:00
 */
public class Test {
    public static void main(String[] args) {
        // 创建 scanner
        Scanner scanner = new Scanner(System.in);

        // 创建两个数值,用以接收
        System.out.print("请输入一个数值: ");
        long before = scanner.nextLong();
        System.out.print("请输入一个数值: " );
        long after = scanner.nextLong();

        // 打印两个数值之间的结果
        System.out.println("\t=====输出结果=====");
        System.out.println("小于: \t" + (before < after));
        System.out.println("小于等于: \t" + (before <= after));
        System.out.println("大于: \t" + (before > after));
        System.out.println("大于等于: \t" + (before >= after));
        System.out.println("等于: \t" + (before == after));
        System.out.println("不等于: \t" + (before != after));
        System.out.println("\t=====END=====");
    }
}