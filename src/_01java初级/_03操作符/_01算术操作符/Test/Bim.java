package _01java初级._03操作符._01算术操作符.Test;

import java.util.Scanner;

/**
 * 类作用: 计算BIM
 * 类说明: 练习,计算BIM
 *
 * @author 彭继工
 * @date 2020 - 02 - 23:12:06
 */
public class Bim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 定义身高
        System.out.print("输入身高: ");
        float height = scanner.nextFloat();

        // 定义体重
        System.out.print("输入体重: ");
        float kg = scanner.nextFloat();

        // 计算公式,体重 / (身高 * 身高)
        // 首先计算出身高计算部分,(还没有涉及 () 相关知识)
        double heightSum = (double) height * height;

        // 计算 BIM 值
        // 将 KG 改成 按斤计算
        kg = kg / 2;
        double result = (double) kg / heightSum;

        // 输出结果
        System.out.format("您的 BIM 是: %.2f",result);
    }
}