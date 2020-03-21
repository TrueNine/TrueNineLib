package cn.how2j._02java中级._02IO._10System_in.Exercise;

import java.io.*;

/**
 * 练习 自动创建类
 * 替换标记
 *
 * @author 彭继工
 * @date 2020-03-20:16:44
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File f = new File("src/cn/how2j/_02java中级/_02IO/_10System_in/file/Clazz.txt");

        // 从控制台输入数据
        setClass(f,"test","integers","str","trueNine");
    }

    public static void setClass(File resources, String className, String intName, String stringName, String author) throws IOException {
        char[] cs = new char[(int) resources.length()];

        // 读取到程序
        BufferedReader br = new BufferedReader(
                new FileReader(resources)
        );
        br.read(cs);
        br.close();

        // 创建一个字符串
        String str = new String(cs);

        // 进行替换
        str = str.replaceAll("@className@", className)
                .replaceAll("@author",author)
                .replaceAll("@stringName@",stringName)
                .replaceAll("@intName@", intName);

        cs = str.toCharArray();

        // 先将数据写入到程序
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(resources)
        );
        bw.write(cs);
        bw.flush();
        bw.close();
    }
}