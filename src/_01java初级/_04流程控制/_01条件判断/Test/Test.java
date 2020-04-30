package _01java初级._04流程控制._01条件判断.Test;

import java.util.Scanner;

/**
 * 类作用: 练习
 * 类说明: 练习BIM
 *
 * @author 彭继工
 * @date 2020 - 02 - 25:9:12
 */
public class Test {
    /** 定义一些需要的常量 */
    private static final float A = 18.5f;
    private static final float B = 24f;
    private static final float C = 27f;
    private static final float D = 30f;
    private static final float E = 35f;

    public static void main(String[] args) {
        // 创建 Scanner
        Scanner scanner = new Scanner(System.in);

        // 接入身高,体重
        System.out.print("请输入身高  M: ");
        float height = scanner.nextFloat();
        System.out.print("请输入体重 KG: ");
        float kg = scanner.nextFloat();

        // 计算 BIM 值,(顺带修改 kg)
        kg /= 2;
        double bim = kg / (height * height);
        // 进行判断输出
        if (A > bim) {
            System.out.println("体重过轻");
        } else if (A <= bim && B > bim) {
            System.out.println("体重正常");
        } else if (B <= bim && C > bim) {
            System.out.println("体重过重");
        } else if (C <= bim && D > bim) {
            System.out.println("轻度肥胖");
        } else if (D <= bim && E > bim) {
            System.out.println("中度肥胖");
        } else if (E <= bim) {
            System.out.println("重度肥胖");
        }
    }
}