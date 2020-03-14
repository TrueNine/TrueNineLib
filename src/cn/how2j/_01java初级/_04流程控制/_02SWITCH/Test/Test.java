package cn.how2j._01java初级._04流程控制._02SWITCH.Test;

import java.util.Scanner;

/**
 * 类作用: 练习
 * 类说明: 通过输入月份,判断季节
 *
 * @author 彭继工
 * @date 2020 - 02 - 26:19:39
 */
public class Test {
    public static void main(String[] args) {
        // 创建 scanner 接收数据
        Scanner scanner = new Scanner(System.in);
        // 接收输入的月份
        System.out.print("请输入月份: ");
        int month = scanner.nextInt();

        // 利用 case 穿透特性
        // 如果不写上 break,则继续执行向下语句
        switch (month) {
            case 1:
            case 2:
            case 3:
                System.out.println("现在是春季");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("现在是夏季");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("现在是秋季");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("现在是冬季");
                break;
            default :
                System.out.println("系统错误,没有此到月份");
        }
    }
}