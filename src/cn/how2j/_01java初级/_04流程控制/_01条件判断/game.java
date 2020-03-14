package cn.how2j._01java初级._04流程控制._01条件判断;

import java.util.Scanner;

/**
 * 类作用: 玩耍
 * 类说明: 给一个1 - 6 的随机数,赌大小
 *
 * @author 彭继工
 * @date 2020 - 02 - 25:15:32
 */
public class game {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 6) + 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您下注的点数,0进入押大小");
        int is = scanner.nextInt();
        if (0 != is) {
            if (number == is) {
                System.out.println("你赢了!!!!!!!!!!!!!!!!!!!!!!");
            } else {
                System.out.println("你输了");
            }
        } else {
            System.out.println("请输入大小,(0小 1大)");
            int isMx = scanner.nextInt();
            if (0 == isMx) {
                String str = number <= 3 ? "赢了" : "输了";
                System.out.println("你押小" + str);
            } else {
                String str = number >= 4 ? "赢了" : "输了";
                System.out.println("你押大" + str);
            }
        }

        String str = number <= 3 ? "小" : "大";
        System.out.println(str + number);
    }
}