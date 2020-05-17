package _02java中级._06多线程._08线程池;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试 java 自带的线程池
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/4
 */
public class Test2 {
    public static void main(String[] args) {

        // 创建一个线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10
                , 15
                , 60
                , TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>()
        );

        // 往线程池内添加任务
        executor.execute(new Thread(() -> {
            System.out.println("往线程池内添加任务");
        }));
    }
}