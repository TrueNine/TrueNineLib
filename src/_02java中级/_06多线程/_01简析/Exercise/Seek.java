package _02java中级._06多线程._01简析.Exercise;

import java.io.*;
import java.util.Scanner;

/**
 * 练习 查找文件,多线程
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/1
 */
public class Seek {
    public static void main(String[] args) {
        SeekText text = new SeekText();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\r请输入目录:\t");
        String path = scanner.next();
        System.out.print("\b\r请输入文件后缀名:\t");
        String fileType = scanner.next();
        System.out.print("\b\r请输入要查找的内容:\t");
        String element = scanner.next();
        text.seek(path, fileType, element);
    }
}

/**
 * 实现 Runnable 接口
 * 多线程查找文件内的内容
 */
class SeekThread implements Runnable {

    private File file;
    private String searchText;

    private SeekThread() {

    }

    /**
     * 构造器,初始化查找的条件
     *
     * @param file       文件
     * @param searchText 查找内容
     */
    public SeekThread(File file, String searchText) {
        this.file = file;
        this.searchText = searchText;
    }

    /**
     * 查找方法,用于 run 方法调用
     * 使用字符缓存流读取文件的每一行内容
     * 查找该行内容是否包含要查找的内容
     *
     * @param file       文件
     * @param searchText 查找的内容
     */
    private void search(File file, String searchText) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(file)
        )) {
            // 定义一个索引,指向行号
            int index = 0;
            while (true) {
                String line = br.readLine();
                if (null == line) {
                    // 没有内容了,直接退出循环
                    break;
                }
                index++;
                // 找到内容直接打印
                if (line.contains(searchText)) {
                    System.out.println(
                            "<<" + file.getAbsolutePath()
                                    + " | " + index + " |line"
                    );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * run 方法
     * 只需要调用 search 方法即可
     */
    @Override
    public void run() {
        search(this.file, this.searchText);
    }
}

/**
 * 查找文件内容
 */
class SeekText {

    private File value;
    private String searchFileType;
    private String searchElement;

    public SeekText() {

    }

    /**
     * 构造器,用于初始化属性
     *
     * @param path           文件路径
     * @param searchFileType 文件后缀
     * @param searchElement  查找内容
     */
    public SeekText(String path, String searchFileType, String searchElement) {
        this.init(path, searchFileType, searchElement);
    }

    /**
     * 用于设置常量
     *
     * @param path           文件路径
     * @param searchFileType 文件后缀名
     * @param searchElement  查找内容
     */
    private void init(String path, String searchFileType, String searchElement) {
        this.value = new File(path);
        this.searchElement = searchElement;
        this.searchFileType = searchFileType;
    }

    /**
     * 查找文件内容,指定文件后缀名
     * 判断文件是文件还是目录
     * 文件: 调用一条线程去查找
     * 目录: 递归
     *
     * @param path           文件路径
     * @param searchFileType 文件后缀名
     * @param searchElement  查找内容
     */
    public void seek(String path, String searchFileType, String searchElement) {
        this.init(path, searchFileType, searchElement);
        if (this.value.isFile() && this.value.getName().endsWith(this.searchFileType)) {
            // 开辟一条线程去查找
            new Thread(new SeekThread(this.value, this.searchElement)).start();
        }
        // 文件则直接递归
        if (this.value.isDirectory()) {
            File[] values = this.value.listFiles();
            if (null != values) {
                for (File temp : values) {
                    seek(temp.getAbsolutePath(), searchFileType, searchElement);
                }
            }
        }
    }
}