package cn.how2j._08数字与字符串._02字符串转换.Exercise;

/**
 * 练习转换字符串
 *
 * @author 彭继工
 * @date 2020-03-08:14:08
 */
public class Test {
    public static void main(String[] args) {
        // 将 3.14转换为字符串
        double doubles = 3.14f;
        String doubleStr = String.valueOf(doubles);
        System.out.println(doubleStr);

        // 将 字符串 3.14转换为数值
        double d = Double.parseDouble(doubleStr);
        System.out.println(d);

        // 测试强行转换
        String print = "3.1a4";
        double test = Double.parseDouble(print);
        System.out.println(test);
    }
}