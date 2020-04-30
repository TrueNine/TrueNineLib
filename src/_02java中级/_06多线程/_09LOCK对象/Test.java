package _02java中级._06多线程._09LOCK对象;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Lock对象
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/5
 */
public class Test {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
