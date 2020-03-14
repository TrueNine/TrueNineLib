package cn.how2j._01java初级._05数组._06二维数组.Test;

import cn.yzdz.random.RandomNumber;

import java.util.Arrays;

/**
 * 类作用: 练习
 * 类说明: 找出二维数组的最小值
 *
 * @author 彭继工
 * @date 2020 - 02 - 29:16:57
 */
public class Test {
    public static void main(String[] args) {
        // 声明一个二维数组, 5 * 5
        int size = 20;
        int[][] twoArray = new int[size][size];

        // 对两个二维数组赋值
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                twoArray[i][j] = RandomNumber.randomInt(1024,true);
            }
        }

        // 打印测试
        System.out.println("打印二维数组");
        for (int i = 0; i < twoArray.length; i++) {
            System.out.println(Arrays.toString(twoArray[i]));
        }

        // 找出二维数组中的最大值
        // 声明临时变量
        int temp = 0;
        int x = 0;
        int y = 0;
        for (int w = 0; w < twoArray.length; w++) {
            for (int n = 0; n < twoArray[w].length; n++) {
                if (twoArray[w][n] > temp) {
                    x = w;
                    y = n;
                    temp = twoArray[w][n];
                }
            }
        }

        // 进行显示处理操作
        x += 1;
        y += 1;

        // 打印测试
        System.out.println("最大值是: " + temp + " 所在的行列: " + x + " 行 " + y + " 列 ");
    }
}