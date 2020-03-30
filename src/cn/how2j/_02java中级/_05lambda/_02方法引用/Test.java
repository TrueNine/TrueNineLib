package cn.how2j._02java中级._05lambda._02方法引用;

import cn.how2j._02java中级._05lambda._02方法引用.Hero;
import cn.yzdz.random.RandomNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试: lambda
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-29:15:21
 */
@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        // 进行初始化
        List<Hero> list = new ArrayList<>();
        int max = 20;
        for (int i = 0; i < max; i++) {
            list.add(new Hero("张三", RandomNumber.randomInt(1000,true)));
        }

        // lambda 表达式
        filter(list,h -> h.hp > 200 && "张三".equals(h.name));

        // lambda 调用静态方法
        filter(list,h -> Test.testHero(h));

        // lambda 调用静态方法的另一种写法
        // 实现匿名类,业务逻辑替换为静态类实现
        // 如果转换, 业务逻辑为 return testHero(h);
        filter(list,Test :: testHero);

        // 测试 lambda 调用对象方法
        // 同上,业务逻辑为 return testheroObject(h);
        Test t = new Test();
        filter(list,t::testHeroObject);

        // 引用容器中的方法

    }

    public static boolean testHero(Hero h) {
        return h.hp > 200 && "张三".equals(h.name);
    }

    public boolean testHeroObject(Hero h) {
        return h.hp > 200 && "张三".equals(h.name);
    }

    public static void filter(List<Hero> hs, Checker c) {
        for (Hero temp : hs) {
            if (c.test(temp)) {
                System.out.println(temp);
            }
        }
    }
}

interface Checker {
    boolean test(Hero h);
}