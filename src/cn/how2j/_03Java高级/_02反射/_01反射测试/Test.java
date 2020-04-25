package cn.how2j._03Java高级._02反射._01反射测试;

import cn.yzdz.outConsole.Print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/23
 */
public class Test {
    /**
     * 反射之前对于Person 的操作
     *
     * 不能在类外部调用私有结构
     */
    @org.junit.Test
    public void t1() {
         // 1. 创建对象
        Person person = new Person("张三",12);

        // 2. 通过对象,调用内部属性和方法
        person.setAge(22);
        int age = person.getAge();


    }

    /**
     * 反射能做的事情
     */
    @org.junit.Test
    @SuppressWarnings("all")
    public void t2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 1. 通过 .class 获取类对象
        Class clazz = Person.class;

        // 2. 通过 类对象,获取构造器
        // 此处构造器必须公开,否则无法调用
        Constructor constructor = clazz.getConstructor(String.class,int.class);

        // 3. 通过 构造器,构造对象
        Object obj = constructor.newInstance("12", 12);
        System.out.println(obj.toString());
        // 进行强转,指向
        Person p = (Person) obj;

        // 4. 通过反射调用指定的属性,和指定的方法
        Field age = clazz.getDeclaredField("age");
        // 进行赋值操作
        age.set(p, 10);

        System.out.println(p.age);

        // 5. 调用方法,指定形参,但此处没有形参
        Method method = clazz.getDeclaredMethod("show");
        method.invoke(p);

        Print.newLine("测试调用私有方法");

        // 通过反射是可以调用私有结构,比如私有的构造器
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("233");

        System.out.println(p1);

        // 通过反射直接修改私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"李四");
        System.out.println(p1.toString());

        // 调用私有方法,同时接受返回值
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        // 调用方法,并接受返回值
        String str = (String) showNation.invoke(p1,"china");
    }
}



class Person {
    private String name;
    public  int age;

    public Person() {

    }
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    private Person (String name) {
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