package _02java中级._02IO._07缓存流;

import java.io.*;

/**
 * 测试缓存流
 *
 * @author 彭继工
 * @date 2020-03-19:14:14
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File src = new File("src/cn/how2j/_02java中级/_02IO/_07缓存流/file/w.txt");
        File dest = new File("src/cn/how2j/_02java中级/_02IO/_07缓存流/file/t.txt");
        if ( ! dest.exists()) {
            dest.getParentFile().mkdirs();
            dest.createNewFile();
        }

        // 测试读取到程序
        FileReader fr = new FileReader(src);
        BufferedReader bfr = new BufferedReader(fr);

        while (true) {
            String str = bfr.readLine();
            if (null == str) {
                break;
            }
            System.out.println(str);
        }
        bfr.close();

        // 测试从程序写出到文件
        FileWriter fw = new FileWriter(dest);
        PrintWriter pw = new PrintWriter(fw);

        // 逐行写出数据
        pw.println("str");
        pw.print("str");
        fw.flush();

        fw.close();
    }
}