package cn.how2j._06类和对象._12单例模式;

/**
 * 类作用: 测试
 * 类说明: 测试枚举单例模式
 *
 * @author 彭继工
 * @date 2020 - 03 - 04:18:33
 */
public class EnumTest {
    public static void main(String[] args) {
        // 调用枚举方法测试
        Test.TEST.getPrint();
        Test.DONG.getPrint();
    }
}

enum Test {
    /**
     * 返回对象
     */
    TEST,
    XIA,
    QIU,
    DONG;

    public void getPrint() {
        System.out.println("打印一句话");
    }
}