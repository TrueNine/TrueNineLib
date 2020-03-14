package cn.how2j._01java初级._08数字与字符串._09MyStringBffer;

import cn.how2j.YzdzStringBuffer;
import cn.yzdz.outConsole.Print;

/**
 * 测试MyStringBuffer
 *
 * @author 彭继工
 * @date 2020-03-10:20:41
 */
public class Exercise {
    public static void main(String[] args) {
        YzdzStringBuffer buffer = new YzdzStringBuffer();

        for (int i = 'A'; i < 'Z'; i++) {
            buffer.append((char) i);
        }

        buffer.insert(25,"我");

        System.out.println(Print.line("测试结果"));
        System.out.println(buffer);
    }
}
