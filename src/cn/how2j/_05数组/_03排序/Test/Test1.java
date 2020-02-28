package cn.how2j._05数组._03排序.Test;

import java.util.Arrays;

/**
 * 类作用: 练习
 * 类说明: 使用选择正排序,然后使用冒泡范排序
 *
 * @author 彭继工
 * @date 2020 - 02 - 28:15:27
 */
public class Test1 {
    public static void main(String[] args) {
        // 创建一个数组
        int[] array = {5, 4, 3, 2, 1};

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        // 使用正排序
        for (int w = 0; w < array.length; w++) {
            for (int n = w; n < array.length; n++) {
                if (array[w] > array[n]) {
                    int temp = array[w];
                    array[w] = array[n];
                    array[n] = temp;
                }
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        // 使用冒泡反排序
        for (int w = 0; w < array.length; w++) {
            for (int n = 0; n < array.length - w - 1; n++) {
                if (array[n + 1] > array[n]) {
                    int temp = array[n + 1];
                    array[n + 1] = array[n];
                    array[n] = temp;
                }
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
