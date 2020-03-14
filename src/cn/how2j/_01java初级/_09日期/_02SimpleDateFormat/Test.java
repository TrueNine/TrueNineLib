package cn.how2j._01java初级._09日期._02SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试格式化日期
 *
 * @author 彭继工
 * @date 2020-03-12:19:33
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("z: yyyy/MM/dd/a hh:mm:ss:SSSS");
        sdf.format(new Date(System.currentTimeMillis()));
        System.out.println(sdf.format(new Date(System.currentTimeMillis())));
    }
}
