package cn.how2j._03Java高级._02反射._05反射获取类结构;

import java.io.Serializable;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/24
 */
public class Greature<T> implements Serializable {
    /**
     * 性别
     */
    private char gender;
    /**
     * 体重
     */
    public double weight;

    /**
     * 呼吸方法
     */
    private void breath() {
        System.out.println("生物在呼吸");
    }

    /**
     * 吃东西
     */
    public void eat() {
        System.out.println("动物正在进食");
    }

}
