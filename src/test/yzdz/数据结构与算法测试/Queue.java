package test.yzdz.数据结构与算法测试;

import cn.yzdz.outConsole.Print;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试实现队列
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-23:13:30
 */
public class Queue <T> {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        // 测试数据的尊却行
        queue.addQueue("测试数据1");
        queue.addQueue("测试数据2");
        queue.addQueue("测试数据3");

        // 测试打印后的结果
        System.out.println(queue.toString());
        System.out.println(queue.showFirst());

        // 测试取出数据
        System.out.println(queue.getQueue());
        System.out.println(Print.line("分割"));
        System.out.println(queue.showFirst());
        System.out.println(queue.toString());
    }

    /**
     * 数组
     * 用于存放数据内容
     */
    Object[] queue = null;

    /**
     * 队列的最大长度
     */
    private int maxSize;

    /**
     * 队列前后端的下标
     * before 随着数据的输入而改变
     * after 随着数据输出而改变
     */
    private int beforeIndex;
    private int afterIndex;

    /**
     * 空构造器
     * 初始化队列为 16 的长度
     */
    public Queue() {
        maxSize = 16;
        beforeIndex = -1;
        afterIndex = -1;
        queue = new Object[maxSize];
    }

    /**
     * 传入指定的值
     * 指定队列的大小
     *
     * @param maxSize 队列的大小
     */
    public Queue(int maxSize) {
        // 调用父类构造器
        super();
        this.maxSize = maxSize;
        queue = new Object[maxSize];
    }

    /**
     * 判断队列是否已经满
     * 当最后的索引指向长度 - 1
     *
     * @return boolean
     */
    public boolean isFull() {
        return afterIndex == maxSize - 1;
    }
    public boolean isFullException() {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        return false;
    }

    /**
     * 判断队列是否为 null
     * 当添加数据的位置和最后指向相等
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return beforeIndex == afterIndex;
    }
    public boolean isEmptyException() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return false;
    }

    public void addQueue(T element) {
        // 队列满时候不能添加数据
        isFullException();
        // 后索引向后移动
        afterIndex ++;
        // 添加数据
        queue[afterIndex] = element;
    }

    /**
     * 将数据移出队列
     *
     * @return 内容
     */
    public T getQueue() {
        isEmptyException();
        beforeIndex ++;
        // 将队列的相应位置出队
        return (T) queue[beforeIndex];
    }

    /**
     * 显示头部数据
     *
     * @return element
     */
    public T showFirst() {
        isEmptyException();
        return (T) queue[beforeIndex + 1];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (isEmpty()) {
            return "queue is null";
        }
        // 此处只遍历数组的有效元素
        for (int i = 0; i < queue.length; i++) {
            result.append("index: ").append(i).append(" :")
                    .append("{")
                    .append(queue[i])
                    .append("}")
                    .append("\n");
        }
        return result.toString();
    }
}