package cn.how2j._03Java高级._02反射._02Class类;

import org.junit.Test;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/23
 */
public class Tests {

    /**
     * 测试获取 Class 的方式1
     */
    @Test
    public void t1() throws ClassNotFoundException {

        /*
        方式1. 通过 .class 属性获取
         */
        Class clazz = Persons.class;
        System.out.println("clazz = " + clazz);

        /*
        方式2. 通过 运行时类对象.getClass() 获取
         */
        Persons p2 = new Persons();
        Class clazz2 = p2.getClass();
        System.out.println("clazz2 = " + clazz2);

        /*
        方式3. Class.forName(); 静态方法,获取
         */
        Class clazz3 = Class.forName("cn.how2j._03Java高级._02反射._02Class类.Persons");
        System.out.println("clazz3 = " + clazz3);

        /*
        方式4. 通过类加载器 ClassLoader()
         */
        ClassLoader classLoader = Tests.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("cn.how2j._03Java高级._02反射._02Class类.Persons");
        System.out.println("clazz4 = " + clazz4);

        // 判断四种获取方式获取的实例是否是同一实例
        // 通过结论发现获取的类都是一致的
        System.out.println(clazz == clazz2);
        System.out.println(clazz2 == clazz3);
        System.out.println(clazz3 == clazz4);
    }
}



class Persons {

    private String name;
    public  int age;

    public Persons() {
        super();
    }
    public Persons(String name,int age) {
        this.name = name;
        this.age = age;
    }

    private Persons (String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("我是一个人");
    }
    private String showNation(String nation) {
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}