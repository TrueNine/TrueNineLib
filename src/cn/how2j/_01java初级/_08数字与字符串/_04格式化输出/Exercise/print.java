package cn.how2j._01java初级._08数字与字符串._04格式化输出.Exercise;

import java.util.Scanner;

/**
 * 练习格式化输出
 *
 * @author 彭继工
 * @date 2020-03-08:18:29
 */
public class print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入人名");
        String personName = scanner.nextLine();

        System.out.println("请输入公司地址");
        String address = scanner.nextLine();

        System.out.format("%s在%s公司上班",personName,address);
    }
}