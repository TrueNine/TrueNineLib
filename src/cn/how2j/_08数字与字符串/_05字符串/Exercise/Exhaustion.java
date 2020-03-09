package cn.how2j._08数字与字符串._05字符串.Exercise;

import cn.yzdz.random.RandomString;

import java.util.Arrays;

/**
 * 练习穷举密码
 * 使用多层 for 和递归
 *
 * @author 彭继工
 * @date 2020-03-08:23:46
 */
public class Exhaustion {
    public static void main(String[] args) {

        // 生成 3 位的随机字符串
        String password = new RandomString().numberAndUppercaseLetter(3);

        // 打印该密码
        System.out.println(password);

        // 使用递归解决
        digui(password);


        // 使用多层 for
        char[] chArr = new char[3];
        export:
        for (int i = 0; i < Byte.MAX_VALUE; i++) {
            for (int j = 0; j < Byte.MAX_VALUE; j++) {
                for (int k = 0; k < Byte.MAX_VALUE; k++) {
                    // 固定三位密码查找
                    chArr[0] = (char) i;
                    chArr[1] = (char) j;
                    chArr[2] = (char) k;
                    String tempArr = new String(chArr);

                    if (password.equals(tempArr)) {
                        System.out.println("找到密码: " + tempArr);
                        break export;
                    }
                }
            }
        }
    }

    public static void digui(String password) {
        if (0 >= password.length()) {
            throw new RuntimeException("传入的字符串不能为 空");
        }
        digui(password,0,new char[password.length()]);
    }
    static boolean flag = false;
    private static void digui(String password,int index,char[] chArr) {
        if (flag) {
            return;
        }

        for (int i = 0; i < Byte.MAX_VALUE; i++) {
            char c = (char) i;
            chArr[index] = c;

            // 不满足长度就继续找,直到长度和字符数组相等
            if (index < chArr.length - 1) {
                // 递归自己寻找下一个
                digui(password,index + 1,chArr);
            } else {
                // 表示已经找完的情况,转换为字符串
                String tempStr = new String(chArr);

                // 判断是否和密码相等
                if (password.equals(tempStr)) {
                    System.out.println("找到密码: " + tempStr);

                    // 结束递归变量
                    flag = true;
                    return;
                }
            }
        }
    }
}