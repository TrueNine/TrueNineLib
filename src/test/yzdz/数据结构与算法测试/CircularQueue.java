package test.yzdz.数据结构与算法测试;

import cn.yzdz.outConsole.Print;
import org.junit.Test;

/**
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-24:13:46
 */
public class CircularQueue <T> {

    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>(3);
        System.out.println(Print.line("测试没有添加数据"));
        System.out.println(q.toString());
        System.out.println(Print.line("测试添加"));
        q.addQueue(13);
        q.addQueue(32);
        System.out.println(q.toString());
        System.out.println(Print.line("取出数据"));
        q.getQueue();
        q.addQueue(24);
        System.out.println(q.toString());
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
     * before 指向队列的第一个元素
     * after 指向队列的最后一个元素 + 1 (留出空缺)
     */
    private int beforeIndex;
    private int afterIndex;

    /**
     * 空构造器
     * 初始化队列为 16 的长度
     */
    public CircularQueue() {
        maxSize = 16;
        beforeIndex = 0;
        afterIndex = 0;
        queue = new Object[maxSize];
    }

    /**
     * 传入指定的值
     * 指定队列的大小
     *
     * @param maxSize 队列的大小
     */
    public CircularQueue(int maxSize) {
        // 调用父类构造器
        super();
        this.maxSize = maxSize;
        queue = new Object[maxSize];
    }

    /**
     * 判断队列是否已经满
     * 最后元素 + 1 % 最大长度 == 最前元素
     *
     * @return boolean
     */
    public boolean isFull() {
        return (afterIndex + 1) % maxSize == beforeIndex;
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
        // 添加数据
        queue[afterIndex] = element;
        // 将afterIndex后移
        afterIndex = (afterIndex + 1) % maxSize;
    }

    /**
     * 将数据移出队列
     *
     * @return 内容
     */
    public T getQueue() {
        isEmptyException();
        // 将队列的相应位置出队
        // 分析出beforeIndex是否指向第一个元素
        // 1. beforeIndex 保存到变量
        int tempIndex = beforeIndex;
        // 2. 将 beforeIndex  后移,考虑取模
        this.beforeIndex = (beforeIndex + 1) % maxSize;
        // 3. 将临时变量索引位置的值返回
        return (T) queue[tempIndex];
    }

    /**
     * 显示头部数据
     *
     * @return element
     */
    public T showFirst() {
        isEmptyException();
        return (T) queue[beforeIndex];
    }

    public int size() {
        /*
        比如 before = 0;
            after = 2;
            maxSize = 3;
            ((2 + 3<5>) - 0<5>) % 3<2>
        比如 before = 1;
            after = 2;
            maxSize = 3;
            ((2 + 3<5>) - 1<4>) % 3<1>
         */
        return ((afterIndex + maxSize) - beforeIndex) % maxSize;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (isEmpty()) {
            return "queue is null";
        }
        // 从 beforeIndex 开始,
        for (int i = beforeIndex; i < this.size(); i++) {
            result.append("index:").append(i % maxSize).append(":")
                    .append("{")
                    .append(queue[i % maxSize])
                    .append("}")
                    .append("\n");
        }
        return result.toString();
    }
}
