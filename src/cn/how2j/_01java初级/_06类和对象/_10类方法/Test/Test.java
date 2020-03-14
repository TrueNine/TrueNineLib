package cn.how2j._01java初级._06类和对象._10类方法.Test;

/**
 * 类作用: 测试
 * 类说明: 测试在类方法中调用对象方法
 *
 * @author 彭继工
 * @date 2020 - 03 - 03:16:55
 */
public class Test {
    /** 此方法为对象方法方法 */
    public void test() {

    }
    /** 静态方法 */
    public static void test2() {
        // 测试在静态方法中调用本类对象方法
        // this.test();

        // 编译不通过
        // 测试持有对象调用
        Test test = new Test();
        test.test();
        // 结果是可以的
        // 所以必须持有对象
    }

    public static void main(String[] args) {

    }
}