package cn.how2j._01java初级._04流程控制._01条件判断.Test;

import java.util.Scanner;

/**
 * 类作用: 练习
 * 类说明: 练习 if 判断闰年
 *
 * @author 彭继工
 * @date 2020 - 02 - 25:14:53
 */
public class Test1 {
    /** 一些常量 */
    public static final int ZERO = 0;
    public static final int MAX = 10000;
    public static final int FOUR = 4;
    public static final int HUNDRED = 100;
    public static final int FOURHUNDRED = 400;

    public static void main(String[] args) {
        // 创建 Scanner,接收输入的年份
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份,(不能输入负数): ");
        int year = scanner.nextInt();

        // 防止输入负数的处理
        if (ZERO >= year) {
            System.out.println("输入的年份不能是负数!");
        } else if (MAX <= year) {
            System.out.println("输入的年份过大");
        } else {
            // 分开处理布尔值
            boolean isHundred = (0 != year % HUNDRED);
            boolean isLeapYear = ((0 == year % FOURHUNDRED) || (0 == year % FOUR)) && isHundred;

            if (isLeapYear) {
                System.out.println("是闰年");
            } else {
                System.out.println("不是闰年");
            }
        }
    }
}
