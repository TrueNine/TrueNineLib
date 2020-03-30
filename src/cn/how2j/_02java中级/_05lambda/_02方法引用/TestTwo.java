package cn.how2j._02java中级._05lambda._02方法引用;

import cn.yzdz.random.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 接着上一个测试
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-29:16:35
 */
@SuppressWarnings("all")
public class TestTwo {
    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        int max = 20;
        for (int i = 0; i < max; i++) {
            list.add(new Hero("张三", RandomNumber.randomInt(2000,true)));
        }

        // 使用 lambda 表达式
        Test.filter(list,h -> h.hp >= 200 && "张三".equals(h.name));

        // 在 lambda 中调用容器中的方法
        Test.filter(list, h -> h.test());

        // 上方法的改写
        Test.filter(list,Hero :: test);

        // 测试引用构造器,匿名类实现
        Supplier<List> s = new Supplier() {
            @Override
            public List get() {
                return new ArrayList<>();
            }
        };
        List list1 = getList(s);

        // lambda 表达式实现
        List list2 = getList( () -> new ArrayList<>());

        // 引用构造器
        List list3 = getList(ArrayList::new);
    }

    public static List getList(Supplier<List> s) {
        return s.get();
    }
}

class Hero {

    String name;
    int hp;

    Hero() {

    }
    Hero(String name,int hp) {
        this.name = name;
        this.hp = hp;
    }
    public boolean test() {
        return this.hp >= 200 && "张三".equals(this.name);
    }
    @Override
    public String toString() {
        return this.name + "|" + this.hp;
    }
}

