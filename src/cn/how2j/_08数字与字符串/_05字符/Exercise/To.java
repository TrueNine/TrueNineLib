package cn.how2j._08数字与字符串._05字符.Exercise;

import java.util.Scanner;

/**
 * 练习
 * 将输入的字符串里的大写字母和数字打印出来
 *
 * @author 彭继工
 * @date 2020-03-08:18:51
 */
public class To {
    public static void main(String[] args) {
        // 输入字符串
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.format("字符是:\t%s",str);

        // 将字符串转换为字符数组
        char[] strArr = str.toCharArray();

        // 找出字符数组内的大写字母和数字并打印
        System.out.println();
        for (int i = 0; i < strArr.length; i++) {
            if (Character.isUpperCase(strArr[i]) || Character.isDigit(strArr[i])) {
                System.out.format("%c",strArr[i]);
            }
        }
    }
}