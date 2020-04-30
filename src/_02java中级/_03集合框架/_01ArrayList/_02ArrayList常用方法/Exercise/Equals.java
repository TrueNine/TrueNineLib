package _02java中级._03集合框架._01ArrayList._02ArrayList常用方法.Exercise;

import cn.how2j.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 判断一个集合内的内容是否相等
 *
 * @author 彭继工
 * @date 2020-03-22:12:01
 */
public class Equals {
    public static void main(String[] args) {
        // 创建一个集合
        List<Hero> list = new ArrayList<>();

        // 向集合内添加内容
        list.add(new Hero("张三", 24));
        list.add(new Hero("李四",24));
        list.add(new Hero("王五",24));

        // 输入姓名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = scanner.nextLine();
        System.out.print("\r\b");

        // 循环遍历该集合
        int index = 0;
        for (Hero temp : list) {
            if (name.equals(temp.name)) {
                System.out.println("找到"
                        + name
                        + "在位置: "
                        + index);
            }
            index ++;
        }
    }
}