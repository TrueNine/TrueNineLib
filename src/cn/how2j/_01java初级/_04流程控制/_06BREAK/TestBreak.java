package cn.how2j._01java初级._04流程控制._06BREAK;

/**
 * 类作用: 测试
 * 类说明: 测试break 标签的特性
 *
 * 经测试是跳出到外部循环的下一句,并非开从头开始执行循环
 *
 * @author 彭继工
 * @date 2020 - 02 - 27:16:30
 */
public class TestBreak {
    public static void main(String[] args) {
        export:
        for(int i = 0; i < 10; i ++) {
            for(int j = 0; j < 10; j ++) {
                if (0 == j % 2) {
                    break export;
                }
            }
        }
    }
}
