package _01java初级._08数字与字符串._07操作字符串.Exercise;

/**
 * 最后一个单词首字母大写大写
 *
 * @author 彭继工
 * @date 2020-03-09:13:42
 */
public class LastWordUpperCase {
    public static void main(String[] args) {
        String str = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";

        // 先转换为字符数组
        char[] strChArr = str.toCharArray();

        int index = str.lastIndexOf(" two ");
        System.out.println(index);
        index ++;
        System.out.println(strChArr[index]);

        // 替换为大写字母,转换为字符串
        strChArr[index] = Character.toUpperCase(strChArr[index]);
        str = new String(strChArr);
        System.out.println(str);
    }
}