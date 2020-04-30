package _02java中级._06多线程._01简析;

/**
 * 测试多线程启动方式
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/1
 */
public class Test {
    public static void main(String[] args) {
        new Thread(Test2 :: new).start();
    }
}

class Test1 extends Thread {

    @Override
    public void start() {

    }
}

class Test2 implements Runnable {
    @Override
    public void run() {

    }
}