package _02java中级._01异常._01异常;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 测试异常的发生
 *
 * @author 彭继工
 * @date 2020-03-14:18:00
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("D:/java233");
        new FileInputStream(f);
    }
}
