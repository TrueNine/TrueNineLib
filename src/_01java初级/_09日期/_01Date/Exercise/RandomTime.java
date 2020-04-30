package _01java初级._09日期._01Date.Exercise;

import cn.yzdz.calculate.Time;
import cn.yzdz.random.RandomNumber;

import java.util.Date;

/**
 * 获取随机时间
 * 1995 0101 - 1231 的随机时间
 *
 * @author 彭继工
 * @date 2020-03-11:18:42
 */
public class RandomTime {
    public static void main(String[] args) {
        // 生成随机时间
        long d = RandomNumber.randomLong(Time.calculateLeapyear(1997),Time.calculateLeapyear(2020),true);
        Date date = new Date(d);

        System.out.println(date);
    }
}