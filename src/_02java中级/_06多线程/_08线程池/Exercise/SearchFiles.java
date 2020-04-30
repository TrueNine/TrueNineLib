package _02java中级._06多线程._08线程池.Exercise;

import cn.yzdz.outConsole.Print;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 练习,使用线程池查找文件
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/4
 */
public class SearchFiles {
    public static void main(String[] args) throws FileNotFoundException {
        // 测试查找文件
        Client.start();
    }
}

/**
 * 用于调用文件查询
 * 面向客户,进行封装
 * 只提供了一个静态方法
 */
class Client {

    /**
     * 用于调度
     * @throws FileNotFoundException 查找文件方法带来的异常
     */
    @SuppressWarnings("all")
    public static void start() throws FileNotFoundException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入文件路径: \t");
            String filePath = scanner.nextLine();
            System.out.print("\b\r\b请输入文件后缀: \t");
            String fileType = scanner.nextLine();
            System.out.print("\b\r\b请输入需要查找的内容: \t");
            String element = scanner.nextLine();

            Print.newLine("正在查询,请稍后");

            // 创建对象,调用方法
            SearchFolder searchFolder = new SearchFolder();
            searchFolder.search(filePath,fileType,element);

            while (true) {
                boolean isExit = false;
                Print.newLine("继续查询输入: 1,输入 exit 退出");
                switch (scanner.nextLine()) {
                    case "1" :
                        Print.newLine("请稍后");
                        isExit = true;
                        break;
                    case "exit" :
                        Print.newLine("正在退出");
                        isExit = true;
                        // 查找线程池刹车,然后退出
                        SearchFolder.poolStop();
                        return;
                    default:
                        System.out.println("输入错误,请重新输入");
                }
                if (isExit) {
                    break;
                }
            }
        }
    }
}

/**
 * 负责调度线程池查找文件
 * 负责遍历文件夹
 */
class SearchFolder {

    /**
     * 核心线程池,通过构造器进行初始化设置
     */
    private static ThreadPoolExecutor pool;

    /**
     * 线程池测试刹车方法
     *
     * @deprecated 不建议使用,直接让线程刹车
     */
    @Deprecated
    public static void poolStop() {
        pool.shutdown();
    }

    /**
     * 空构造器
     * 初始化线程池,都使用默认设置,不建议使用
     * 线程数量: 10
     * 线程最大扩容数量: 15
     * 线程等待时间: 30S
     * 线程容器:
     *
     * @deprecated 不建议使用,尽量自己设置参数
     */
    @Deprecated
    public SearchFolder() {
        this.init(10, 15, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }

    /**
     * 构造器,初始化线程池
     * 调用<code>{@link #init(int, int, int, TimeUnit, BlockingQueue)}</code>进行初始化设置
     *
     * @param min      平常线程数量
     * @param max      增加的线程数量
     * @param time     回收实践单位
     * @param timeUnit 时间计量单位
     * @param queue    存放的容器
     */
    public SearchFolder(int min,int max,int time,TimeUnit timeUnit,BlockingQueue<Runnable> queue) {
        this.init(min, max, time, timeUnit, queue);
    }

    /**
     * 用于初始化线程池
     * 目前只支持容器是 BlockingQueue<Runnable> 的容器
     *
     * @param min      平常线程数量
     * @param max      增加的线程数量
     * @param time     回收实践单位
     * @param timeUnit 时间计量单位
     * @param queue    存放的容器
     */
    private void init(int min, int max, int time, TimeUnit timeUnit, BlockingQueue<Runnable> queue) {
        // 根据数据创建线程池
        pool = new ThreadPoolExecutor(min, max, time, timeUnit, queue);
    }

    /**
     * 对外封装方法
     * 可以以字符串的形式输入文件内容
     *
     * @param filePath      文件路径
     * @param fileType      文件后缀类型
     * @param searchElement 查找内容
     * @throws FileNotFoundException 查找带来的异常
     */
    public void search(String filePath, String fileType, String searchElement) throws FileNotFoundException {
        File file = new File(filePath);
        this.search(file, fileType, searchElement);
    }

    /**
     * 指定需要查找的: 文件,文件后缀,查找内容
     * 如果是文件夹,则递归查找
     * 如果是指定后缀的文件,新建一个查找文件线程查找文件,此处继续遍历文件夹
     * 如果传入的是文件则直接查找
     * 路径不对或者没有文件会抛出异常
     *
     * @param folder      需要查找的文件
     * @param fileElement 文件后缀名
     * @param element     查找内容
     * @throws FileNotFoundException 找不到文件或者文件不存在
     * @deprecated 此方法不建议在外部使用
     */
    @Deprecated
    private void search(File folder, String fileElement, String element) throws FileNotFoundException {
        if ( ! folder.exists()) {
            throw new FileNotFoundException("查找的文件不存在");
        }
        if (folder.isDirectory()) {
            // 创建一个文件数组
            File[] files = folder.listFiles();
            if (null != files) {
                // 递归调用
                for (File temp : files) {
                    search(temp, fileElement, element);
                }
            }
        }
        if (folder.isFile()) {
            // 判断是否以指定后缀结尾
            if (folder.getName().endsWith(fileElement)) {
                // 往线程池内推送一个任务,查找我呢间
                this.pool.execute(
                        new Files(folder, element)
                );
            }
        }
    }
}

/**
 * 线程类,负责调度多线程
 * 用于放到线程池内
 *
 */
class Files implements Runnable {

    /**
     * 需要查找的文件
     */
    private File file;
    /**
     * 需要查找的内容
     */
    private String element;

    /**
     * 空构造器,不让用,直接私有
     *
     * @deprecated 私有的构造器,没啥作用,也不要用
     */
    @Deprecated
    private Files() {

    }

    /**
     * 公开构造器
     * 传入一些初始化好的参数
     * 去查找文件
     *
     * @param file 文件
     * @param element 查找的内容
     */
    public Files(File file, String element) {
        this.init(file, element);
    }

    /**
     * 用于初始化参数
     */
    private void init(File file,String element) {
        this.file = file;
        this.element = element;
    }

    @Override
    public void run() {
        // 调用文件查找方法
        try {
            this.fileLine(this.file, this.element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件查找内容
     * 使用 IO字符缓存流,逐行读取,查找是否包含此字符串
     *
     * @param file    文件
     * @param element 需要查找的内容
     * @throws IOException IO流带来的异常
     */
    public void fileLine(File file, String element) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int index = 0;
            while (true) {
                String line = br.readLine();
                if (null == line) {
                    break;
                }
                index++;
                // 以字符串比对
                if (line.contains(element)) {
                    // 打印找到的行数和绝对路径
                    System.out.println(
                            ">>:" + file.getAbsolutePath()
                                    + ":|:" + index + "|line"
                    );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}