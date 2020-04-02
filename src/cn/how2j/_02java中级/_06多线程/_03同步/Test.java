package cn.how2j._02java中级._06多线程._03同步;

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
public class Test {
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
                    number.add();
                }
            });
            cuts[i] = new Thread(() -> {
                synchronized (lock) {
                    number.cut();
                }
            });
        }
        // 先启动 add 线程,再启动 cut 线程
        for (int i = 0; i < max; i++) {
            // 暂停 10 millis
            Thread.sleep(1);
            adds[i].start();
            cuts[i].start();
        }

        // 测试数据的准确性
        System.out.println(number.getNumber());
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
        number += 1;
    }
    public void cut() {
        number -= 1;
    }
}
