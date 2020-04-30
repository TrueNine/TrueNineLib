package _01java初级._03操作符._06三元操作符.Test;

import java.util.Scanner;

/**
 * 类作用: 三元操作符
 * 类说明: 练习三元操作符,判断是否是工作日
 *
 * @author 彭继工
 * @date 2020 - 02 - 24:9:53
 */
public class Test {
    public static void main(String[] args) {
        // 创建 Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入 1 - 7: ");
        int value = scanner.nextInt();

        String str = value <= 5 ? "是" : "不是";

        System.out.println("今天" + str + "工作日");
    }
}