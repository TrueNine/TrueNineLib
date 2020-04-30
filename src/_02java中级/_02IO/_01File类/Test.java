package _02java中级._02IO._01File类;

import java.io.File;

/**
 * @author 彭继工
 * @date 2020-03-17:12:07
 */
public class Test {
    public static void main(String[] args) {
        // 使用相对路径
        File f = new File("file/w.txt");
        // 使用绝对路径,建议使用 / 而不是 \\(WIN)
        File f1 = new File("D:\\JAVA_IDEA_CODE\\file\\w.txt");

        // 使用文件对象作为父目录
        File f2 = new File("D:\\JAVA_IDEA_CODE\\file\\");
        File f4 = new File(f2,"w.txt");



        System.out.println(f.getAbsolutePath());
    }
}
