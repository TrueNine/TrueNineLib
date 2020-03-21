package cn.how2j._02java中级._02IO._09对象流;

import org.junit.After;
import org.junit.Assert;

import java.io.*;

/**
 * 测试序列化
 *
 * @author 彭继工
 * @date 2020-03-20:15:23
 */
public class Test {

    @org.junit.Test
    public void test() throws IOException, ClassNotFoundException {
        File f = new File("src/cn/how2j/_02java中级/_02IO/_09对象流/file/Object.myxml");

        // 创建一个对象,并且序列化
        Hero hero = new Hero();
        hero.name = "张三";
        hero.age = 17;

        // 创建对象流并将对象存入文件
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(f));

        // 将对象存入文件
        oos.writeObject(hero);

        // 从文件取出对象(Object,需要强制转换)
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f)
        );

        // 创建引用,强制转换,取出
        Object obj = ois.readObject();
        Hero h = null;
        if (obj instanceof Hero) {
            h = (Hero) obj;
        }

        // 测试
        if (null != h) {
            System.out.println(h.name + h.age);
        }
    }
}

/**
 * 一个实现了 Serializable 接口
 * 可以序列化的类
 */
class Hero implements Serializable {
    public String name;
    public int age;
}