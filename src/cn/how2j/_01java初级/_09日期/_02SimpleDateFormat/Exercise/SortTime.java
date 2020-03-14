package cn.how2j._01java初级._09日期._02SimpleDateFormat.Exercise;

import cn.yzdz.calculate.Time;
import cn.yzdz.outConsole.Print;
import cn.yzdz.random.RandomNumber;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 根据小时进行排序
 *
 * @author 彭继工
 * @date 2020-03-12:20:41
 */
public class SortTime {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        // 生成 9 个随机日期
        Date[] d = new Date[9];
        // 初始化该该时间数组
        for (int i = 0; i < d.length; i++) {
            d[i] = new Date(RandomNumber.randomLong(Time.calculateLeapyear(
                    1940),
                    Time.calculateLeapyear(2000) + Time.calculateLeapyear(1971),
                    true));
        }

        Print<Date> print = new Print<>();
        print.printArray(d,1);

        // 根据时分秒进行排序
        // 冒泡排序
        for (int w = 0; w < d.length; w++) {
            boolean is = true;
            for (int n = 0; n < d.length - w - 1; n++) {
                String beforeStr = sdf.format(d[n]);
                String afterStr = sdf.format(d[n + 1]);

                int be = Integer.parseInt(beforeStr);
                int af = Integer.parseInt(afterStr);

                if (be > af) {
                    Date temp = d[n];
                    d[n] = d[n + 1];
                    d[n + 1] = temp;
                    is = false;
                }
            }
            if(is) {
                break;
            }
        }
        // 打印测试
        System.out.println(Print.line("测试结果"));;
        print.printArray(d,1);
    }
}