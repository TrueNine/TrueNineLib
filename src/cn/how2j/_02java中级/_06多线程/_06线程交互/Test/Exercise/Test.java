package cn.how2j._02java中级._06多线程._06线程交互.Test.Exercise;

import cn.yzdz.random.RandomChar;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * 练习: 生产者消费者模式
 * 生产者往栈内推送数据
 * 消费者从栈内取出数据打印
 * 不能取出空数据,生产者如果生产到了 10 个停止生产
 * 角色: 生产者,消费者,栈,测试类
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/3
 */
public class Test {
    public static void main(String[] args) {
        // 新建一个栈
        MyStack stack = new MyStack();

        // 新建一个消费者,和一个生产者,同时启动
        String userName = "王小二";
        new Thread(new Consumer(userName, stack),userName + "线程").start();
        String administratorName = "胡扒皮";
        new Thread(new Producer(administratorName, stack), administratorName + "线程").start();

    }
}

/**
 * 栈,用于存放数据
 * 只能存放 Character
 * 此栈必须是线程安全的
 * 干脆自己写一个栈
 */
class MyStack {
    /**
     * 核心栈,约定只能存入 10 个数据
     */
    Stack<Character> value = new Stack<>();

    /**
     * 栈能存放的数据量
     * 约定为 10 个
     */
    private static final int MAX_SIZE = 10;

    /**
     * 栈本身的长度
     * 初始化为 0,0表示栈内的数据为空
     * 在push和pull的时候,更改这个值
     */
    private int size;

    /**
     * 空构造器
     * 啥事儿都没干
     * 约定显示提供
     */
    public MyStack() {
        // 栈的长度初始化为 0
        size = 0;
    }

    /**
     * 往栈内推送数据
     * 不能超过最大值
     * 否则让其他线程等待
     *
     * @param ch 需要推送的数据
     * @throws InterruptedException wait给的异常
     */
    public synchronized void push(char ch) throws InterruptedException {
        while (size >= MAX_SIZE) {
            // 让其他线程等待,栈已满
            // 直到其他的消费者取走 才能继续向上累加
            this.wait();
        }
        // 往栈内推送数据,长度 + 1
        this.value.push(ch);
        this.size += 1;
        // 通知其他消费者过来取
        this.notifyAll();
    }

    /**
     * 向栈外取出数据
     * 如果栈内的元素没有,消费者等待
     * 直到生产者提供数据
     *
     * @return char
     * @throws InterruptedException wait给的异常
     */
    public synchronized char pull() throws InterruptedException {
        // 如果栈内没有数据,让其他线程睡觉
        while (0 >= this.size) {
            this.wait();
        }
        // 长度减少,并且返回值
        this.size -= 1;
        // 唤醒其他所有线程
        this.notifyAll();
        return value.pop();
    }
}

/**
 * 生产者
 * 负责往栈内推送随机大写字符
 */
class Producer implements Runnable {

    /**
     * 生产者的姓名
     * 在构造器进行初始化
     */
    private String name;

    /**
     * 生产者需要压入的栈
     * 在构造器内进行初始化
     */
    private MyStack stack;

    /**
     * 临时变量
     * 用于存放临时生成的字符
     */
    private char tempChar;

    /**
     * 空构造器
     * 不让用,直接私有
     */
    private Producer() {

    }

    public Producer(String name,MyStack stack) {
        // 设置生产者的姓名
        this.name = name;
        // 设置需要操作的栈
        this.stack = stack;
    }

    /**
     * 重写的 run
     * 负责生产大写随机字母,压入到栈中
     * 压入的栈为: 初始化该对象的时候传入的栈
     */
    @Override
    public void run() {
        while (true) {
            try {
                push(this.stack);
                System.out.println("生产者" + this.name + "生产了一个: " + this.tempChar);
                // 休息一秒,以便查看
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Error: 生产者压栈异常");
                e.printStackTrace();
            }
        }
    }

    /**
     * 静态方法,返回一个大写字母
     *
     * @return char
     */
    private static char randomUpperCaseLetter() {
        RandomChar random = new RandomChar();
        return random.uppercaseLetter();
    }

    /**
     * 往栈内压数据
     * 压入大写随机字母
     *
     * @param stack 需要压入得栈
     * @throws InterruptedException MyStack带来的异常
     */
    private synchronized void push(MyStack stack) throws InterruptedException {
        this.tempChar = randomUpperCaseLetter();
        stack.push(this.tempChar);
    }
}

/**
 * 消费者
 * 负责从栈内取出字符打印
 */
class Consumer implements Runnable {

    /**
     * 消费者名称
     */
    private String name;

    /**
     * 消费者需要取出的栈
     */
    private MyStack stack;

    /**
     * 空构造器
     * 不让用,直接私有化
     */
    private Consumer() {

    }

    /**
     * 构造器,从栈中取出数据,打印到控制台
     *
     * @param name  消费者名字
     * @param stack 消费者需要取出的栈
     */
    public Consumer(String name, MyStack stack) {
        // 设置消费者的名称
        this.name = name;
        // 设置消费者需要取出的栈
        this.stack = stack;
    }

    /**
     * 重写的 run 方法
     * 从栈内取出数据,并打印
     */
    @Override
    public void run() {
       while (true) {
           // 从栈内取出数据
           try {
               System.out.println("消费者" + this.name + "消费了一个" + this.pull());
               // 休息一秒,以便查看
               TimeUnit.SECONDS.sleep(3);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    /**
     * 取出方法,从栈中取出大写字母
     *
     * @return char
     * @throws InterruptedException MyStack.pull 带来的异常
     */
    private char pull () throws InterruptedException {
        return this.stack.pull();
    }
}