package _01java初级._03操作符._04位运算;

/**
 * 类作用:
 * 类说明:
 *
 * @author 彭继工
 * @date 2020 - 02 - 24:8:51
 */
public class Test {
    public static void main(String[] args) {
        int print = 0b00001010;
        System.out.println(print);

        int print2 = 0b00001100;
        System.out.println(print2);

        // 测试 2 * 16
        System.out.println(2 * 16);
        System.out.println(16 << 1);
        System.out.println(8 << 2);
        System.out.println(4 << 3);
        System.out.println(2 << 4);

        System.out.println("分割线");
        System.out.println(Integer.toBinaryString(5));
        System.out.println(4 >>> 1);
        System.out.println("测试负数无符号右移 >>>");
        System.out.println(-3 >>> 1);
    }
}
