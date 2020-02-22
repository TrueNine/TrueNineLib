package _01面向对象._03方法.Test;

/**
 * 类作用: 英雄类
 * 类说明: 增加了一些英雄的方法
 *
 * @author 彭继工
 * @date 2020 - 02 - 22:11:17
 */
public class Method {
    /** 英雄名称 */
    String name;
    /** 英雄血量 */
    float hp;
    /** 英雄护甲 */
    float armor;
    /** 移动速度 */
    int moveSpeed;
    /** 攻击速度 */
    float attackSpeed;
    /** 杀人次数 */
    short k;
    /** 死亡次数 */
    short d;
    /** 助攻次数 */
    short a;
    /** 补刀次数 */
    int killCreatures;
    /** 杀人前说的话 */
    String lillBefore;
    /** 杀人后说的话 */
    String killAfter;

    /**
     * 一个空的主方法
     *
     * @param args 主方法参数
     */
    public static void main(String[] args) {

    }

    /**
     * 超神方法
     */
    void legendary() {
        System.out.println("Method.legendary" + "超神了");
    }

    /**
     * 返回当前英雄的 hp 血量
     *
     * @return 当前英雄的血量
     */
    float getHp() {
        System.out.println("Method.getHp" + "查看当前血量");
        return hp;
    }

    void recovery(float blood) {
        System.out.println("Method.recovery" + "回血");
        hp += blood;
    }
}