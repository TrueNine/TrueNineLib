package cn.how2j._04泛型._03通配符.Exercise;

import cn.how2j.Hero;

import java.util.ArrayList;

/**
 * 练习 万物归一
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-29:13:37
 */
public class Test {
    public static void iterate(ArrayList<? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }

    public static void main(String[] args) {

    }
}