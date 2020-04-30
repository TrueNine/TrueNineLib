package _01java初级._07接口与继承._12综合练习.Test;

/**
 * 类作用: 练习
 * 类说明: 接口
 * 练习用的 猫 接口
 *
 * @author 彭继工
 * @date 2020 - 03 - 07:23:38
 */
public interface Pet {
    /**
     * 查看宠物的名称
     *
     * @return 字符串
     */
    String getName();

    /**
     * 设置宠物的名称
     *
     * @param name 名称
     */
    void setName(String name);

    /**
     * 宠物游游玩的方法
     */
    void play();
}