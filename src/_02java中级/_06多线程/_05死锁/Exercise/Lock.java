package _02java中级._06多线程._05死锁.Exercise;

import java.util.concurrent.TimeUnit;

/**
 * 练习: 死锁
 * 错误: 之前想的是,获取单把锁,环形获取
 * 但是这样锁不住,所以要一个线程,持有两把锁
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/3
 */
public class Lock {
    public static void main(String[] args) {
        // 创建三把锁
        String one = "";
        String two = "";
        String three = "";

        // 循环死锁
        // a 死锁,拿到 one ,获取 two
        new Thread(() -> {
            synchronized (one) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (two) {
                    synchronized (three) {
                        System.out.println();
                    }
                }
            }
        }).start();

        // b 死锁 拿到 two 获取 three
        new Thread(() -> {
            synchronized (two) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (three) {
                    synchronized (one) {
                        System.out.println();
                    }
                }
            }
        }).start();

        // c 死锁 拿到 three 获取 one
        new Thread(() -> {
            synchronized (three) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (one) {
                    synchronized (two) {
                        System.out.println();
                    }
                }
            }
        }).start();
    }
}