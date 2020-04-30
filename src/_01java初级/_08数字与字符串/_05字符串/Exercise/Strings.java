package _01java初级._08数字与字符串._05字符串.Exercise;

import cn.yzdz.random.RandomString;

/**
 * 生成随机字符串
 * 写好了工具类,随便生成
 *
 * @author 彭继工
 * @date 2020-03-08:22:41
 */
public class Strings {
    public static void main(String[] args) {
        RandomString random = new RandomString();

        // 不仅可以随机字母数字,还可以随机到符号
        System.out.println(random.numberAndLetterAndSign(40));
    }
}
