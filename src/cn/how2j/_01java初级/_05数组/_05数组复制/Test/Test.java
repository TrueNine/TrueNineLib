package cn.how2j._01java初级._05数组._05数组复制.Test;

import cn.yzdz.random.RandomNumber;

import java.util.Arrays;

/**
 * 类作用: 练习
 * 类说明: 拼接数组
 *
 * @author 彭继工
 * @date 2020 - 02 - 29:12:21
 */
public class Test {
    public static void main(String[] args) {
        // 创建两个数组,长度随机在5 - 10 之间
        int[] a = new int[RandomNumber.randomInt(5,false) + 5];
        int[] b = new int[RandomNumber.randomInt(5,false) + 5];

        // 使用随机数初始化数组
        for (int i = 0; i < a.length; i++) {
            a[i] = RandomNumber.randomInt(5,true);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = RandomNumber.randomInt(5,true);
        }

        // 打印测试
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
        System.out.println("Arrays.toString(b) = " + Arrays.toString(b));

        // 进行数组拼接
        // 定义一个变量,该变量的长度是 两个数组的和
        int sumLength = a.length + b.length;

        // 创建新的数组
        int[] array = new int[sumLength];

        // 对数组进行 赋值复制操作
        System.arraycopy(a,0,array,0,a.length);
        // 拼接第二个数组
        System.arraycopy(b,0,array,a.length,b.length);

        // 测试打印拼接好的数组
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
