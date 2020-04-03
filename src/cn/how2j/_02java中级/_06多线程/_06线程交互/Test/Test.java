package cn.how2j._02java中级._06多线程._06线程交互.Test;

import java.util.concurrent.TimeUnit;

/**
 * 测试卖票
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/3
 */
public class Test {
    public static void main(String[] args) {
        Station station = new Station();

        Thread user = new Thread(() -> {
            while (true) {
                // 否则开始卖票
                station.sellTicket();
                System.out.println("车站卖了一张票,现在票数是: " + station.getTickets());

                try {
                    TimeUnit.MILLISECONDS.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        user.start();

        Thread administrator = new Thread(() -> {
            while (true) {
                station.buyTicket();
                System.out.println("管理员进行补票,现在的票数是: " + station.getTickets());

                // 等待 1/10 秒
                // 补票速度慢于取票速度
                try {
                    TimeUnit.MILLISECONDS.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        administrator.start();
    }
}

/**
 * 车站类
 */
class Station {

    private int tickets = 0;

    /**
     * 买票的方法
     */
    public synchronized void buyTicket () {
        if (this.tickets > 1) {
            // 通知那些需要的线程,可以过来买票了
            this.notify();
        }
        this.tickets += 1;
    }

    /**
     * 卖票的方法
     */
    public synchronized void sellTicket () {
        if (this.tickets <= 0) {
            try {
                // 通知占有的线程,没票了,去等
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.tickets -= 1;
    }

    /**
     * 获取当前所拥有的票数
     *
     * @return int
     */
    public synchronized int getTickets() {
        return this.tickets;
    }
}