package cn.how2j._03Java高级._02反射._05反射获取类结构;

import cn.how2j._03Java高级._01注解._02自定义注释.MyAnnotation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;

/**
 * 一个丰富的 java bean
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/24
 */
@cn.how2j._03Java高级._02反射._05反射获取类结构.MyAnnotation("hi")
public class Person extends Greature<String> implements Comparable<String>, MyAnnotation {

    private String name;
    int age;
    public int id;

    public Person() {

    }

    @cn.how2j._03Java高级._02反射._05反射获取类结构.MyAnnotation("abc")
    private Person(String name) {
        this.name = name;
    }
    Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @cn.how2j._03Java高级._02反射._05反射获取类结构.MyAnnotation
    private String show (String nation) throws FileNotFoundException {
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    public String display(String interests, int age) {
        return interests;
    }

    private static void showDesc() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

