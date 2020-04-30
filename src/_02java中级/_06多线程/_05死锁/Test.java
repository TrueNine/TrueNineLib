package _02java中级._06多线程._05死锁;

import java.util.concurrent.TimeUnit;

/**
 * 测试死锁
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/3
 */
public class Test {
    public static void main(String[] args) {
        String lockOne = "one";
        String lockTwo = "two";

        // 声明两条线程,互相死锁
        new Thread(() -> {
            // 锁住对象1
            synchronized (lockOne) {
                // 等待 3秒
                try {
                    System.out.println(
                            Thread.currentThread().getName()
                    + "正在占有对象1");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 占有对象2,在拥有对象1的同时
                synchronized (lockTwo) {
                    System.out.println("获取了对象2");
                }
            }
        },"线程1").start();

        // 开启第二条线程,占有对象2,获取对象1
        new Thread(() -> {
            // 占有对象2
            synchronized (lockTwo) {
                try {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + "正在占有对象 2");
                    // 暂停 3 秒
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 占有对象1,在拥有对象2的同时
                synchronized (lockOne) {
                    System.out.println("获得了对象1");
                }
            }
        },"线程2").start();
    }
}