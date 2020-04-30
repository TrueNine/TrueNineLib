package _02java中级._03集合框架._02其他集合._02二叉树.Exercise;

import cn.how2j.Hero;
import cn.yzdz.random.RandomNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习 英雄二叉树
 * 根据英雄的血量进行排序
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-25:16:18
 */
public class Tree {
    public static void main(String[] args) {
        HeroTree tree = new HeroTree();
        // 传入 10 个随机血量的英雄
        int counter = 10;
        for (int i = 0; i < counter; i++) {
            tree.add(
                    new Hero("张" + i
                            , RandomNumber.randomInt(100,100 * 100,true)));
        }
        System.out.println(tree.getList().toString());
    }
}

class HeroTree {
    HeroTree left;
    HeroTree right;
    Hero value;

    /**
     * 空构造器
     */
    HeroTree() {

    }

    /**
     * 添加方法
     * 往英雄二叉树内添加数据
     * @param v 添加的英雄
     */
    public void add(Hero v) {
        if (null == this.value) {
            value = v;
        } else {
            if (v.hp <= this.value.hp) {
                if (null == left) {
                    left = new HeroTree();
                }
                left.add(v);
            } else {
                if (null == right) {
                    right = new HeroTree();
                }
                right.add(v);
            }
        }
    }

    public List<Hero> getList() {
        List<Hero> list = new ArrayList<>();

        // 往容器内添加数据
        if (null != left) {
            list.addAll(left.getList());
        }
        list.add(value);
        if (null != right) {
            list.addAll(right.getList());
        }
        return list;
    }
}