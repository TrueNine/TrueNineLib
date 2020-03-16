package cn.how2j._02java中级._01异常._06综合练习;

/**
 * 测试综合练习
 *
 * @author 彭继工
 * @date 2020-03-16:11:22
 */
public class Test {
    public static void main(String[] args) {
        Account account = new Account(200);
        CheckingAccount zhipiao = new CheckingAccount(300, 20);

        try {
            zhipiao.withdraw(320);
        } catch (OverrdarftException e) {
            e.printStackTrace();
        }
    }
}
