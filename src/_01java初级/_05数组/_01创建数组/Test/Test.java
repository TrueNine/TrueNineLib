package _01java初级._05数组._01创建数组.Test;

/**
 * 类作用: 练习
 * 类说明: 找出一个数组内最小的数值
 *
 * @author 彭继工
 * @date 2020 - 02 - 28:12:59
 */
public class Test {
    public static void main(String[] args) {
        // 声明一个数组,并且赋随机值
        int[] a = new int[5];

        // 循环赋随机值
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
            System.out.println(i + " | " + a[i]);
        }

        // 找出最小的值
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            System.out.println("index = " + index);
            if (a[i] < index) {
                index = a[i];
            }
        }

        // 打印说明
        System.out.println("index = " + index);
    }
}