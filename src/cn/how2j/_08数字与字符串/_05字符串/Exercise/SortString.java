package cn.how2j._08数字与字符串._05字符串.Exercise;

import cn.yzdz.random.RandomString;

import java.util.Arrays;

/**
 * 对字符串进行排序
 *
 * @author 彭继工
 * @date 2020-03-08:22:49
 */
public class SortString {
    public static void main(String[] args) {
        // 声明一个长度 8 的字符串数组,存放随机字符串
        String[] strArr = new String[8];

        // 对数组赋值
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = new RandomString().letter(5);
        }

        System.out.println(Arrays.toString(strArr));

        // 进行排序,冒泡排序
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr.length - i - 1; j++) {
                // 过程很复杂
                if ((Character.toUpperCase(strArr[j].toCharArray()[0])) > (Character.toUpperCase(strArr[j + 1].toCharArray()[0]))) {
                    String temp = strArr[j];
                    strArr[j] = strArr[j + 1];
                    strArr[j + 1] = temp;
                }
            }
        }

        // 打印测试
        System.out.println(Arrays.toString(strArr));
    }
}