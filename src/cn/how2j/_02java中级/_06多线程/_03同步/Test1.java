package cn.how2j._02java中级._06多线程._03同步;

import java.util.concurrent.TimeUnit;

/**
 * 测试一些同步方法
 * 测试: 同一环境下,两种线程
 * 同时修改一个方法的值
 * 声明一把锁,只有持有这把锁才能修改值
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/2
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // 声明一把锁
        final Object lock = new Object();

        // 声明两种线程,但持有的锁是一致的
        Number number = new Number();
        // 声明一个线程数组,存放两种线程
        int max = 1024;
        Thread[] adds = new Thread[max];
        Thread[] cuts = new Thread[max];
        for (int i = 0; i < max; i++) {
            adds[i] = new Thread(() -> {
                // 持有该对象的锁才能进行操作
                synchronized (lock) {
                    int temp = number.getNumber();
                    number.add();
                    System.out.println(Thread.currentThread().getName() + "加了,结果是：" + number.getNumber() + " 加前是：" + temp);
                }
            }, "第" + i + "个加线程");
            cuts[i] = new Thread(() -> {
                synchronized (lock) {
                    int temp = number.getNumber();
                    number.cut();
                    System.out.println(Thread.currentThread().getName() + "减了,结果是：" + number.getNumber() + "减前是：" + temp);
                }
            }, "第" + i + "个减线程");
            // 启动线程
            adds[i].start();
            cuts[i].start();
        }

        // 此处等待所有线程执行完毕,如果没有执行完,强行加入当前线程
        // 此处等待四秒
        TimeUnit.SECONDS.sleep(4);
        for (int i = 0; i < max; i++) {
            adds[i].join();
            cuts[i].join();
        }

        // 测试数据的准确性
        System.out.println("最后结果" + number.getNumber());
    }
}

class Number {

    private int number = 1024;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void add() {
        this.number++;
    }

    public void cut() {
        this.number--;
    }
}