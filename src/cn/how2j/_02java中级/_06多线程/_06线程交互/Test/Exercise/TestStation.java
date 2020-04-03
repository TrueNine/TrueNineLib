package cn.how2j._02java中级._06多线程._06线程交互.Test.Exercise;

import java.util.concurrent.TimeUnit;

/**
 * 练习: 反卖票
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/3
 */
public class TestStation {
    public static void main(String[] args) {
        // 创建一个车站
        Station station = new Station();

        // 创建两条线程,2 5
        int userMax = 5;
        for (int i = 1; i < userMax; i++) {
            new Thread(() -> {
                while (true) {
                    station.buyTicket();
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"用户" + i).start();
        }
        int administratorMax = 2;
        for (int i = 1; i < administratorMax; i++) {
            new Thread(() -> {
                while (true) {
                    station.sellTicket();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"管理员" + i).start();
        }
    }
}

/**
 * 车站
 */
class Station {

    private int tickets = 0;
    private final int MAXSIZE = 3;

    public synchronized void buyTicket() {
        if (this.tickets >= MAXSIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.tickets += 1;
        System.out.println(Thread.currentThread().getName() + "添加了一张票,现在票数是: " + getTickets());
        // 通知其他线程可以买票
        this.notify();
    }

    public synchronized void sellTicket() {
        // 此处有可能唤醒买票线程,所以一直判断,一直睡
        while (this.tickets <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.tickets -= 1;
        System.out.println(Thread.currentThread().getName() + "买走了一张票,现在票数是: " + getTickets());
        // 卖票之后,通知补票
        this.notify();
    }
    public int getTickets() {
        return this.tickets;
    }
}