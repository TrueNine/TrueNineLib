package cn.how2j._04流程控制._08综合练习.Test1;

/**
 * 类作用:
 * 类说明:
 *
 * @author 彭继工
 * @date 2020 - 02 - 27:19:02
 */
public class Test3 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (a = -100; a <= 100; a ++) {
            for(b = -100; b <= 100; b ++) {
                for(c = -100; c <= 100; c ++) {
                    for(d = -100; d <= 100; d ++) {
                        // 表达式太长,使用布尔变量代替
                        boolean A = 8 == (a + b);
                        boolean B = 6 == (c - d);
                        boolean C = 14 == (a + c);
                        boolean D = 10 == (b + d);
                        boolean is = A && B && C && D;

                        if (is) {
                            System.out.println("a: " + a);
                            System.out.println("b: " + b);
                            System.out.println("c: " + c);
                            System.out.println("d: " + d);
                        }
                    }
                }
            }
        }
    }
}