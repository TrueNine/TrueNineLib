package cn.how2j._03操作符.Test;

import java.util.Scanner;

/**
 * 类作用: 求和
 * 类说明: 练习求和,使用Scanner
 *
 * @author 彭继工
 * @date 2020 - 02 - 23:11:35
 */
public class Test {
    public static void main(String[] args) {
        // 引入 Scanner
        Scanner scanner = new Scanner(System.in);

        // 读入两个数值
        System.out.println("请输入求和前缀");
        int beforeNumber = scanner.nextInt();
        System.out.println("请输入求和后缀");
        int afterNumber = scanner.nextInt();

        // 进行求和操作
        //定义一个 long 类型,以防结果溢出
        long sum = beforeNumber + afterNumber;
        System.out.println("求和结果是: " + sum);
    }
}