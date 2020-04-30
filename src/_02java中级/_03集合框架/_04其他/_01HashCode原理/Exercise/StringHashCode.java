package _02java中级._03集合框架._04其他._01HashCode原理.Exercise;

import org.junit.Test;

/**
 * 练习: 自定义 String 的 HashCode
 * 根据算式自定义 hashCode
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-28:14:14
 */
public class StringHashCode {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        // 测试数据
        int length = hash("我日");
        System.out.println(length);
    }

    /**
     * 计算 hashcode
     *
     * @param str 字符串
     * @return hashCode 值
     */
    public static int courtyard = 2000;
    public static int hash(String str) {
        // 将传入的值改变为 字符数组
        char[] cs = str.toCharArray();

        // 将所有的值相加
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            max += cs[i];
        }
        max *= 23;
        max %= courtyard;


        return max;
    }
}