package cn.how2j._01java初级._04流程控制._01条件判断;

/**
 * 类作用: 测试
 * 类说明: 测试 if 的 ; 表达式
 *
 * @author 彭继工
 * @date 2020 - 02 - 25:9:16
 */
public class TestIf {
    public static void main(String[] args) {
        boolean flag = false;
        // ; 本身就是表达式
        if (flag) ;
        // 无论如何都会执行这句
        System.out.println("1");
    }
}
