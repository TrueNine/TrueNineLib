package _01java初级._04流程控制._08综合练习.Test1;

/**
 * 类作用: 练习
 * 类说明: 测试水仙花数
 *
 * @author 彭继工
 * @date 2020 - 02 - 27:18:22
 */
public class Test2 {

    /** 百位数 */
    public static final int BAIWEI = 100;
    /** 千位数 */
    public static final int QIANWEI = 1000;

    public static void main(String[] args) {
        // 一层循环解决
        for (int i = BAIWEI; i < QIANWEI; i++) {
            // 定义内部临时变量,分别得到每位数的值
            // 221 / 100 = 2
            int baiwei = i / 100;
            // (221 / 10 = 22) % 10 = 2
            int shiwei = i / 10 % 10;
            // 221 % 10 = 1
            int gewei = i % 10;

            // 计算水仙花数的立方
            int result = baiwei * baiwei * baiwei;
            result += shiwei * shiwei * shiwei;
            result += gewei * gewei * gewei;

            // 判断是否为水仙花数
            if (result == i) {
                // 分别输出百位,十位,个位
                System.out.print("baiwei = " + baiwei + " ");
                System.out.print("shiwei = " + shiwei + " ");
                System.out.print("gewei = " + gewei + " ");

                // 输出结果位数
                System.out.println("找到水仙花数: " + result);
            }
        }
    }
}