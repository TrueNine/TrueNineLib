package cn.how2j._02java中级._06多线程._03同步;

/**
 * 测试一些同步方法
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/2
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // 声明一个不可变的对象,作为锁
        final Object lock = new Object();



        // 稍后修改这个值
        Number number = new Number();


        // 声明一千条线程
        int max = 1000;
        Thread[] add = new Thread[max];
        Thread[] cut = new Thread[max];
        for (int i = 0; i < max; i++) {
            Thread addThread = new Thread(() -> {
                synchronized (lock) {
                    number.setNumber(number.number + 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread cutThread = new Thread(() -> {
                synchronized (lock) {
                    number.setNumber(number.number - 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            // 启动线程,并添加到当前数组中
            addThread.start();
            cutThread.start();
            add[i] = addThread;
            cut[i] = cutThread;
        }

        // 先增加,再减除
        // 将线程加入到当前线程
        for (Thread temp : add) {
            temp.join();
        }
        for (Thread temp : cut) {
            temp.join();
        }

        System.out.println(number.getNumber());
    }
}

class Number {
    int number = 1024;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}