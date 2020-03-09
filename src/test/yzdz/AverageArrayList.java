package test.yzdz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 使用 ArrayLIst 解决
 * 取中间值
 *
 * @author 随
 * @date 2020-03-08:23:18
 */
public class AverageArrayList {
    public static void main(String[] args) {
        // 准备一个 ArrayList
        List<Integer> list = new ArrayList <Integer>();

        Scanner scanner = new Scanner(System.in);
        // 进行添加数据
        while (true) {
            System.out.print("请输入数据,0退出: \t");
            int number = scanner.nextInt();
            if (0 != number) {
                list.add(number);
            } else {
                break;
            }
        }

        // 打印测试
        System.out.println("您输入的数据如下:==============");
        System.out.println(list.toString());

        // 进行排序,直接实现 comparator 排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // 打印测试
        System.out.println("进行排序后====================");
        System.out.println(list.toString());

        // 取中间值
        System.out.println("中间值是: " + list.get(list.size() / 2));
    }
}