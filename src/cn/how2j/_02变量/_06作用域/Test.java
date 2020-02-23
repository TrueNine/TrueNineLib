package cn.how2j._02变量._06作用域;

/**
 * 类作用: 测试
 * 类说明: 测试作用域
 *
 * @author 彭继工
 * @date 2020 - 02 - 23:10:09
 */
public class Test {

    /** 此处为 属性,值是 1024 */
    int i = 1024;

    public void method(int i) {
        System.out.println("Test.method");
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        System.out.println("Test.main");
        // 此处传入的参数是 5
        new Test().method(24);
    }
}