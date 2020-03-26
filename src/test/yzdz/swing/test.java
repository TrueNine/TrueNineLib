package test.yzdz.swing;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-26:15:06
 */
public class test {
    public static void main(String[] args) {
            Set<String> set = new LinkedHashSet<>();
        set.add("张三");
        set.add("李四");
        System.out.println(set.toString());
    }
}