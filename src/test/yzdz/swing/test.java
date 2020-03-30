package test.yzdz.swing;

import java.util.*;
import java.util.function.Supplier;

/**
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-26:15:06
 */
public class test {
    public static void main(String[] args) {
        // 直接传递匿名类
        insertFirst(new Supplier<List<Number>>() {
            @Override
            public List<Number> get() {
                return new ArrayList<>();
            }
        }, "数组容器");

        // 转换成 lambda
        insertFirst(() -> new ArrayList<>(), "没有类型返回");

        // 更加简写
        insertFirst(LinkedList<Number>::new,"没有类型");
    }

    /**
     * 传入的内容为一个可以查看对象的接口
     * 可以直接返回该对象类型
     *
     * @param s    对象类型
     * @param type 对象描述
     */
    private static void insertFirst(Supplier<List<Number>> s, String type) {
        List<Number> list = s.get();
        System.out.println(list.toString() + "类型为: " + type);
    }
}