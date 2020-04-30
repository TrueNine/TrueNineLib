package _02java中级._02IO._06编码.Exercise;

import java.io.UnsupportedEncodingException;

/**
 * 练习,找出对应的字符
 *
 * @author 彭继工
 * @date 2020-03-19:13:01
 */
public class Cha {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] code = {(byte) 0XE5, (byte) 0XB1, (byte) 0X8C};
        System.out.println(new String(code,"UTF-8"));
    }
}