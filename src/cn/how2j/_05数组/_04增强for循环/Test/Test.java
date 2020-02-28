package cn.how2j._05数组._04增强for循环.Test;

import java.util.Arrays;

/**
 * 类作用: 练习
 * 类说明: 使用增强 for 遍历找出最大值
 *
 * @author 彭继工
 * @date 2020 - 02 - 28:15:55
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {100,10,102,103};

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        // 定义一个临时变量,存储比较值
        int max = 0;
        for (int temp : array) {
            if (max < temp) {
                max = temp;
            }
        }

        System.out.println("max = " + max);
    }
}