package cn.how2j._04流程控制._06BREAK.Test;

/**
 * 类作用: 练习
 * 类说明: 练习复利
 *
 * F = p* ( (1+r)^n );
 *
 * @author 彭继工
 * @date 2020 - 02 - 27:16:04
 */
public class Test {
    public static void main(String[] args) {
        // 计算每年
        int fundMonth = 1000;
        int fundYear = fundMonth * 12;
        // 定义利率
        float rate = 0.2f;

        // F = p* ( (1+r)^n );

        // 计算利率
        // 总和
        int sum = 0;
        // 目标钱数
        int target = 1000 * 1000;

        for (int w = 1; w < 100; w++) {
            // 定义年数
            int year = w;
            float compoundinterestrate = 1;

            for (int n = 0; n < year; n++) {
                compoundinterestrate *= (1 + rate);
            }

            // 计算复利
            int compoundInterest = (int) (fundYear * compoundinterestrate);
            sum += compoundInterest;
            System.out.println("经过" + year + "年,总收入: " + sum);

            if (sum >= target) {
                System.out.println("一共需要: " + year + " 累计收入: " + target);
                break;
            }
        }
    }
}