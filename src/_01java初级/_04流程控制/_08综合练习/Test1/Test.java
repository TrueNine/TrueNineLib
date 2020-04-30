package _01java初级._04流程控制._08综合练习.Test1;

/**
 * 类作用: 练习
 * 类说明: 黄金分割点0.618
 *
 * @author 彭继工
 * @date 2020 - 02 - 27:16:40
 */
public class Test {
    /** 需要的最大值 */
    private static final int  MAX = 32767;
    /** 黄金分割点 */
    private static final float RANGE = 0.618f;
    /** 最大的比较数值 */
    private static double MINDIFF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 定义分子分母
        int fenzi = 0;
        int fenmu = 0;

        // 结果分子和分母
        float resultFenzi = 0;
        float resultFenmu = 0;

        for (fenzi = 1; fenzi <= MAX; fenzi ++) {
            for (fenmu = 1; fenmu <= MAX; fenmu ++) {
                // 分子和分母不能同时为偶数
                if (0 == fenzi %2 && 0 == fenmu % 2) {
                    continue;
                } else {
                    // 取值,此处必须是浮点运算,所以需要强转
                    float value = (float) fenzi / fenmu;

                    // 取 离黄金分割点最近的差值
                    float diff = value - RANGE;

                    // 取绝对值
                    diff = diff < 0 ? 0 - diff : diff;

                    // 找出最小的差值,并且取出分子和分母
                    if (diff < MINDIFF) {
                        MINDIFF = diff;
                        // 取出分子和分母
                        resultFenzi = fenzi;
                        resultFenmu = fenmu;
                    }
                }
            }
        }

        double resultSum = resultFenzi / resultFenmu;
        System.out.println("离黄金分割点最近的值是: " + resultFenzi + " / " + resultFenmu + " = " + resultSum);
    }
}