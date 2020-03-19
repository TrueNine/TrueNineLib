package cn.how2j._02java中级._02IO._01File类.Exercise;

import java.io.File;

/**
 * 练习遍历文件
 * 同时遍历子文件
 *
 * @author 彭继工
 * @date 2020-03-17:12:44
 */
public class FileForeach {
    public static void main(String[] args) {
        // 创建文件
        File f = new File("C:/WINDOWS");
        System.out.println(f.isFile());

        // 调用方法遍历下方文件,使用递归
        files(f);

        // 打印测试
        System.out.println("最大文件是: "
            + maxFile.getParent() + maxFile.getName()
            + "最小文件是: "
            + minFile.getParent() + minFile.getName()
        );
    }

    boolean isReturn = false;
    static long max = 0;
    static long min = Long.MAX_VALUE;
    static File maxFile = null;
    static File minFile = null;

    public static void files (File file) {
        files(file,1);
    }
    public static void files(File file,int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("-");
        }
        System.out.print(index + ":" + file.getName());
        if (file.isDirectory()) {
            System.out.print("^" + "\n");
        }

       File[] fileArray = file.listFiles();

       if ( ! (null == fileArray || 0 == fileArray.length)) {
           for (int i = 0; i < fileArray.length; i++) {
                // 判断内容是否是目录,如果是目录则递归
               if (fileArray[i].isDirectory()) {
                   files(fileArray[i],index + 1);
               } else {
                   // 否则就是文件,进行判断
                   if (fileArray[i].length() > max) {
                       max = fileArray[i].length();
                       maxFile = fileArray[i];
                   }
                   if (0 != fileArray[i].length() && fileArray[i].length() < min) {
                       min = fileArray[i].length();
                       minFile = fileArray[i];
                   }
               }
           }
       }
    }
}