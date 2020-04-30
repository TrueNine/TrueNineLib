package _01java初级._08数字与字符串._09StringBuffer.Exercise;

import cn.yzdz.outConsole.Print;
import cn.yzdz.random.RandomString;

/**
 * 比较String 和 StringBuffer 的性能
 * 可以见得,差距不止一星半点
 *
 * @author 彭继工
 * @date 2020-03-10:12:10
 */
public class Comparators {
    public static void main(String[] args) {
        // 准备
        String str = new String();
        StringBuffer buffer = new StringBuffer();
        RandomString random = new RandomString();
        int counter = 100 * 1000;

        long start = System.currentTimeMillis();

        for (int i = 0; i < counter; i++) {
            str += random.letter(5);
        }

        long end = System.currentTimeMillis();

        System.out.println(Print.line("String拼接结果"));
        System.out.println(end - start);

        // 测试 StringBuffer
        long s = System.currentTimeMillis();

        for (int i = 0; i < counter; i++) {
            buffer.append(random.letter(5));
        }

        long e = System.currentTimeMillis();
        System.out.println(Print.line("Buffer的拼接结果"));
        System.out.println(e - s);
    }
}