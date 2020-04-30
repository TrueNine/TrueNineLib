package _01java初级._08数字与字符串._07操作字符串.Exercise;

/**
 * 单词首字母大写
 *
 * @author 彭继工
 * @date 2020-03-09:12:55
 */
public class UpperCase {
    public static void main(String[] args) {
        // 给出一句英文句子
        String str = "let there be light";
        System.out.println(str);

        // 用空格进行分割
        String[] strings = str.split(" ");

        // 循环替换第一个字符
        for (int i = 0; i < strings.length; i++) {
            // 获取首字母字符
            char ch = strings[i].toCharArray()[0];
            // 强行转换为大写
            ch = Character.toUpperCase(ch);

            // 进行替换
            char[] tempArr = strings[i].toCharArray();
            tempArr[0] = ch;
            strings[i] = new String(tempArr);
        }

        // 进行拼接
        str = "";
        for (int i = 0; i < strings.length; i++) {
            str += strings[i] + " ";
        }
        str = str.trim();
        System.out.println(str);
    }
}