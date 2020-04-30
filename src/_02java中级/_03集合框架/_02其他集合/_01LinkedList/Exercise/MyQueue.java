package _02java中级._03集合框架._02其他集合._01LinkedList.Exercise;

/**
 * 练习 实现此接口
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-24:16:42
 */
public interface MyQueue<T> {
    /**
     * 往栈内推送数据
     *
     * @param o 推送的数据
     */
    void push(Object o);

    /**
     * 从栈内取出数据
     * 取出最前面的数据
     *
     * @return 内容
     */
    T pull();

    /**
     * 取出栈内的第一个数据
     *
     * @return 内容
     */
    T peek();
}
