package cn.how2j._08数字与字符串._07操作字符串.Exercise;

/**
 * 字符串最后一个字母大写
 *
 * @author 彭继工
 * @date 2020-03-09:13:39
 */
public class LastUpperCase {
    public static void main(String[] args) {
        // 创建一个字符串
        String str = "lengendarye";

        // 进行字符数组倒腾
        char[] strChArr = str.toCharArray();
        strChArr[strChArr.length - 1] = Character.toUpperCase(strChArr[strChArr.length - 1]);

        // 换回字符串
        str = new String(strChArr);
        System.out.println(str);
    }
}