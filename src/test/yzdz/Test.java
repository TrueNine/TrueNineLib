package test.yzdz;

import cn.yzdz.YzdzList;
import cn.yzdz.random.RandomNumber;
import cn.yzdz.random.RandomString;

/**
 * 类作用: 测试类
 * 类说明: 用于测试自己写的一些工具类
 *
 * @author 彭继工
 * @date 2020 - 02 - 29:13:49
 */
public class Test {
    public static void main(String[] args) {
        RandomString randomString = new RandomString();
        System.out.println(randomString.numberAndLetterAndSignAndChinese(100));
    }
}