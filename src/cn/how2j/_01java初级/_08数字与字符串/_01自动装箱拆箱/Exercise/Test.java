package cn.how2j._01java初级._08数字与字符串._01自动装箱拆箱.Exercise;

/**
 * 练习自动装箱拆箱
 *
 * @author 彭继工
 * @date 2020-03-08:13:28
 */
public class Test {
    public static void main(String[] args) {
        // 测试 byte,short,long,double 自动装拆箱
        // 初始化基本类型
        byte b = 12;
        short s = 123;
        long l = 3242325;
        float f = 1.23f;
        double d = 3124.231241;

        // 自动装箱
        Byte bt = b;
        Short st = s;
        Long lt = l;
        Float ft = f;
        Double dt = d;

        // 进行自动拆箱测试
        b = bt;
        s = st;
        l = lt;
        f = ft;
        d = dt;

        // 测试 byte 和 int 能否自动装箱
        int test = 123;
        // 与基本类型机制一样
        Byte test2 = (byte) test;

        byte test3 = 13;
        // 同样需要强制转换
        Integer test4 = (int) test3;

        // 获取 byte 的最大值
        System.out.println(Byte.MAX_VALUE);
    }
}