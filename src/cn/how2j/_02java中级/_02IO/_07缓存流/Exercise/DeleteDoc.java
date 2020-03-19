package cn.how2j._02java中级._02IO._07缓存流.Exercise;

import java.io.*;

/**
 * 练习 删除注释
 *
 * @author 彭继工
 * @date 2020-03-19:17:11
 */
public class DeleteDoc {
    public static void main(String[] args) throws IOException {
        File f = new File("src/cn/how2j/_02java中级/_02IO/_07缓存流/file/解密文件.txt");
        File d = new File("src/cn/how2j/_02java中级/_02IO/_07缓存流/file/目标文件.txt");
        // 使用缓存流读取数据
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);

        FileWriter fw = new FileWriter(d);
        PrintWriter pw = new PrintWriter(fw);

        // 逐行读取,清除注释行
        while (true) {
            String str = bfr.readLine();
            if (null == str) {
                break;
            }
            // 去除空格判断
            String temp = str.trim();
            // 如果以 // 开头则不写出
            if (temp.startsWith("/") || temp.startsWith("*")) {
                continue;
            }
            pw.flush();
            pw.println(str);
        }
        fr.close();
        pw.close();
    }
}