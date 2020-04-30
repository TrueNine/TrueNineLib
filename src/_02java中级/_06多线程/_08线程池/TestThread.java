package _02java中级._06多线程._08线程池;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 测试自定义线程池
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/4
 */
public class TestThread {

    @Test
    public void tests() throws InterruptedException {
        // 初始化一个线程池,长度为 10
        ThreadPool pool = new ThreadPool(10);

        int sleepTime = 1000;

        // 测试往任务池内推送任务
        int max = 1024;
        while (max > 0) {
            max --;
            pool.add(() -> {
                System.out.println("正在执行任务");
            });
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            // 让时间越来越短
            sleepTime = sleepTime > 1 ? sleepTime -= 100 : sleepTime;
        }
    }
}

/**
 * 线程池
 */
class ThreadPool {
    /**
     * 线程池大小
     */
    private int PoolSize;

    /**
     * 任务存储池
     * 静态提供
     */
    private static Pool pool = new Pool();

    /**
     * 构造器,初始化线程池的大小
     *
     * @param poolSize 线程池大小
     */
    public ThreadPool(int poolSize) {
        this.PoolSize = poolSize;
        // 锁住并启动线程
        synchronized (ThreadPool.getPool().getCollection()) {
            for (int i = 0; i < poolSize; i++) {
                new Thread(new TaskThread("任务线程: " + i)).start();
            }
        }
    }

    /**
     * 对外提供的任务池 get
     *
     * @return Pool 任务池
     */
    public static Pool getPool() {
        return pool;
    }

    /**
     * 往任务容器内推送任务
     *
     * @param thread Runnable
     */
    public void add(Runnable thread) {
        // 锁住任务池
        synchronized (pool.getCollection()) {
            // 向任务池推送
            pool.getCollection().add(thread);
            // 唤醒其他接收任务的线程,接收任务
            pool.getCollection().notifyAll();
        }
    }
}

/**
 * 任务池
 * 线程池持有该对象,并向任务池提供
 */
class Pool {

    /**
     * 核心容器
     * 用于存放任务
     */
    private LinkedList<Runnable> pool = new LinkedList<>();

    /**
     * 返回该容器,以便操作
     *
     * @return LinkedList<Runnable>
     */
    public LinkedList<Runnable> getCollection() {
        return pool;
    }
}

/**
 * 任务调度线程
 */
class TaskThread implements Runnable {

    /**
     * 执行的任务名称
     */
    String name;

    /**
     * 接受到的任务
     */
    Runnable task;

    public TaskThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 开始启动线程
        System.out.println("启动: " + this.name);
        // 一直锁住任务池,等待新的任务到来
        while (true) {
            synchronized (ThreadPool.getPool().getCollection()) {
                // 判断是否为空,为空则进入睡眠
                while (ThreadPool.getPool().getCollection().isEmpty()) {
                    try {
                        ThreadPool.getPool().getCollection().wait();
                    } catch (InterruptedException e) {}
                }
                // 将任务取出,然后执行
                this.task = ThreadPool.getPool().getCollection().removeLast();
                // 通知其他线程可以继续添加任务
                ThreadPool.getPool().getCollection().notifyAll();
            }
            System.out.println(this.name + "接受任务并执行");
            // 执行任务,然后回到顶部继续等待任务
            task.run();
        }
    }
}