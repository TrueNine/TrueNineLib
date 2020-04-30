package _01java初级._05数组._07Arrays.Test;

import cn.yzdz.random.RandomNumber;

import java.util.Arrays;

/**
 * 类作用: 练习
 * 类说明: 给二维数组排序
 *
 * 思想是给一个一维数组排序,然后赋值回二维数组
 *
 * @author 彭继工
 * @date 2020 - 02 - 29:18:08
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个 5 * 8 的数组
        int[][] twoArray = new int[5][8];

        // 对数组进行赋值
        for (int w = 0; w < twoArray.length; w++) {
            for (int n = 0; n < twoArray[w].length; n++) {
                twoArray[w][n] = RandomNumber.randomInt(100,false);
            }
        }

        // 打印测试
        System.out.println("排序前操作");
        for(int[] tempArr : twoArray) {
            System.out.println(Arrays.toString(tempArr));
        }

        // 进行排序
        // 创建一个长度是 二维数组 的 一维数组
        int[] oneArray = new int[twoArray.length * twoArray[0].length];

        // 平铺到一维数组
        for (int i = 0; i < twoArray.length; i++) {
            System.arraycopy(twoArray[i],0,oneArray,i * twoArray[i].length,twoArray[i].length);
        }

        // 打印一维数组
        System.out.println("平铺为一维数组");
        System.out.println(Arrays.toString(oneArray));

        // 对一维数组paixu
        Arrays.sort(oneArray);
        System.out.println("排序后");
        System.out.println(Arrays.toString(oneArray));

        // 将一维数组,放置到二维数组
        for (int i = 0; i < twoArray.length; i++) {
            System.arraycopy(oneArray,i * twoArray[i].length,twoArray[i],0,twoArray[i].length);
        }

        // 打印测试结果
        System.out.println("放回到二维数组");
        for (int[] tempArr : twoArray) {
            System.out.println(Arrays.toString(tempArr));
        }
    }
}