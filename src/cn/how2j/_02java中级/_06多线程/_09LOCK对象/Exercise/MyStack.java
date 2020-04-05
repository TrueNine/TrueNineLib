package cn.how2j._02java中级._06多线程._09LOCK对象.Exercise;

import cn.yzdz.outConsole.Print;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在练习-线程安全的MyStack 练习中，使用synchronized把MyStack修改为了线程安全的类。
 *
 * 接下来，借助Lock把MyStack修改为线程安全的类
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/5
 */
public class MyStack {
    public static void main(String[] args) throws InterruptedException {
        MyStacks<String> stack = new MyStacks<>();
        while (true) {
            new Thread(() -> {
                int index = 0;
                while (true) {
                    index++;
                    Print.newLine("往栈内添加数据");
                    stack.push("数据" + index);
                    Print.newLine("测试查看栈顶");
                    System.out.println(stack.peek());
                }
            }).start();
        }
    }
}

class MyStacks<E> {

    /**
     * 栈的长度
     * 只能存放指定长度的数据
     */
    private int size;

    /**
     * 核心容器
     * 用于实现栈
     *
     * @see LinkedList 使用此类实现
     */
    private LinkedList<E> stack = new LinkedList<>();

    /**
     * 核心锁,用于控制线程安全
     *
     * @see ReentrantLock 使用此类实现
     */
    private Lock stackLock = new ReentrantLock();

    public void push(E e) {
        // 获取锁,如果 3 秒内没有获取到,自动放弃
        boolean is = false;
        try {
            is = stackLock.tryLock(3,TimeUnit.SECONDS);
            stack.addLast(e);
            this.size += 1;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            if (is) {
                stackLock.unlock();
            }
        }
    }
    public E pull() {
        // 获取锁,如果 3 秒内没有获取到,自动放弃
        boolean is = false;
        E e = null;
        try {
            is = stackLock.tryLock(3,TimeUnit.SECONDS);
            e = this.stack.removeLast();
            this.size -= 1;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            if (is) {
                stackLock.unlock();
            }
        }
        return e;
    }
    public E peek() {
        // 获取锁,如果 3 秒内没有获取到,自动放弃
        boolean is = false;
        E e = null;
        try {
            is = stackLock.tryLock(3,TimeUnit.SECONDS);
            e = this.stack.getLast();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            if (is) {
                stackLock.unlock();
            }
        }
        return e;
    }
    public int size() {
        int l = -1;
        try {
            stackLock.lock();
            l = size;
        } finally {
            stackLock.unlock();
        }
        return l;
    }
}