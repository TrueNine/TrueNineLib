package cn.how2j._02java中级._03集合框架._02其他集合._02二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试自己写一个二叉树
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-25:15:14
 */
public class Test {
    public static void main(String[] args) {
        Tree<String> t = new Tree<>();
        t.add("我日他大爷");
        t.add("我日他大");
        t.add("我日他");
        t.add("我日");
        t.add("我");
        System.out.println(t.getList().toString());
    }
}

/**
 * 测试的二叉树
 * 当前支持泛型
 */
class Tree <T> {
    /**
     * 左右节点
     */
    private Tree left;
    private Tree right;

    /**
     * 中间节点
     */
    Object value;

    /**
     * 空构造器
     * 初始化当前树为一个空的树
     * 中间节点设置为 1024
     * 中间的 code 默认设置为 1024
     */
    Tree() {

    }

    /**
     * 往二叉树内添加内容
     * 添加的内容会默认排序好
     */
    public void add(T value) {
       if (null == this.value) {
           this.value = value;
       } else {
           if (value.hashCode() <= this.value.hashCode()) {
               if (null == left) {
                   left = new Tree<T>();
               }
               left.add(value);
           } else {
               if (null == right) {
                   right = new Tree<T>();
               }
               right.add(value);
           }
       }
    }

    /**
     * 将当前树返回
     *
     * @return List
     */
    public List<T> getList() {
        List<T> result = new ArrayList<>();

        if (null != left) {
            result.addAll(left.getList());
        }
        result.add((T) value);
        if (null != right) {
            result.addAll(right.getList());
        }
        return result;
    }
}