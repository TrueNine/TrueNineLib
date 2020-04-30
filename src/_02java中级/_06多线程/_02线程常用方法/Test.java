package _02java中级._06多线程._02线程常用方法;

/**
 * 测试一些常用的线程方法
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/1
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始线程");
        Thread.currentThread().sleep(1000);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("结束线程");
    }
}
