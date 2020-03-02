package cn.how2j._06类和对象._03方法重载;

/**
 * 类作用: 测试
 * 类说明: 测试多重方法
 *
 * @author 彭继工
 * @date 2020 - 03 - 02:14:31
 */
public class Tests {
    public static void main(String[] args) {
        test(1,2,3,4,5,6,7,8);
    }

    /**
     * 测试可变参数
     * 测试发现,如果引入可变参数,就不能再设置其他参数了
     *
     * @param number 测试参数
     */
    public static void test(int ... number) {
        // 如同一个数组一样处理
        for (int temp : number) {
            System.out.println(temp);
        }
    }
}
