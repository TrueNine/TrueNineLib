package cn.how2j._01java初级._05数组._02初始化数组.Test;

/**
 * 类作用: 练习
 * 类说明: 练习数组反转
 *
 * @author 彭继工
 * @date 2020 - 02 - 28:14:46
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个长度 5 的数组
        int[] array = new int[10];

        // 赋随机值
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        // 倒序前打印
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i] + " ");
        }


        // 进行倒序
        // 对循环取中间值
        for (int i = 0; i < array.length / 2; i++) {
            // 此处 多 - 1,防止数组越界
            int tempArrayLastIndex = array.length - i - 1;
            int temp = array[i];
            array[i] = array[tempArrayLastIndex];
            array[tempArrayLastIndex] = temp;
        }

        // 倒序后打印
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i] + " ");
        }
    }
}