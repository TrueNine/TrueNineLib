package _01java初级._08数字与字符串._07操作字符串.Exercise;

/**
 * 间隔字母大写
 *
 * @author 彭继工
 * @date 2020-03-09:13:27
 */
public class SpaceUpperCase {
    public static void main(String[] args) {
        String str = "lengendarysafgeggrthjytjkykyuk";

        // 转换为字符数组
        char[] strChArr = str.toCharArray();

        // 将 2 - 1 的倍数的字母全转换为大写
        for (int i = 0; i < strChArr.length; i++) {
            if (0 == i % 2 && Character.isLetter(strChArr[i])) {
                strChArr[i] = Character.toUpperCase(strChArr[i]);
            }
        }
        str = new String(strChArr);
        System.out.println(str);
    }
}