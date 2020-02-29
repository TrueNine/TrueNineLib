package test.yzdz;

import cn.yzdz.random.RandomNumber;

/**
 * 类作用: 测试类
 * 类说明: 用于测试自己写的一些工具类
 *
 * @author 彭继工
 * @date 2020 - 02 - 29:13:49
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int ir = RandomNumber.randomInt();
            System.out.println("ir = " + ir);
        }
    }
}
