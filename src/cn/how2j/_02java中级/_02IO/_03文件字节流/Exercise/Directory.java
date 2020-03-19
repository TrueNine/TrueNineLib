package cn.how2j._02java中级._02IO._03文件字节流.Exercise;

import cn.yzdz.outConsole.Print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 练习,确保文件没有父目录仍然可以创建
 * @author 彭继工
 * @date 2020-03-18:11:47
 */
public class Directory {
    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File f = new File("D:/testjavaio/w.txt");
        // 查看文件是否存在文件存在
        System.out.println(f.exists());

        // 创建一个父目录,并且判断是否存在,如果不存在则创建
        File dir = new File(f.getParent());
        if ( ! dir.exists()) {
            boolean is = dir.mkdirs();
            System.out.println(is ? "父目录创建成功" : "父目录创建失败");
        }

        // 就可以进行操作
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);

            // 开始介入数据
            byte[] all = {33,34,35,46,56,76};
            fos.write(all);
            System.out.println("文件写出操作完成");
            Print.line("分割线");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.close();
            System.out.println("关闭文件流");
        }
    }
}