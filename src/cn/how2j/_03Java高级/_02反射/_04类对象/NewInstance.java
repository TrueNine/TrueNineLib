package cn.how2j._03Java高级._02反射._04类对象;

import org.junit.Test;

import java.util.Random;

/**
 * 测试通过反射实例化运行时类对象
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/23
 */
public class NewInstance {

    /**
     * newInstance() 创建对应运行时类的方法
     * 默认调用空参构造器,内部调用了运行时类的空参构造器
     * 想使用必须提供空参构造器
     * 权限不能私有
     * 要求: 在 javabean 中 提供 空参构造器
     * 便于通过反射创建运行时对象
     * 类继承此类时,默认调用supper()有此空参构造器
     *
     * @throws IllegalAccessException s
     * @throws InstantiationException s
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        // 此处可以指定泛型
        // 当前的泛型决定了返回值
        Class<Persons> clazz = Persons.class;
        // JDK9 之后不推荐使用
        Persons persons = clazz.newInstance();
        System.out.println("obj = " + persons);
    }

    /**
     * 创建一个指定类的对象
     *
     * @param classPath 指定类的参数名
     * @return 创建的对象
     * @throws ClassNotFoundException s
     * @throws IllegalAccessException s
     * @throws InstantiationException s
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
    @Test
    public void test3() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        int number = new Random().nextInt(3);
        String classPath = "";
        switch (number) {
            case 0:
                classPath = "java.lang.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "java.lang.String";
                break;
            default:
                throw new RuntimeException("出现随机异常");
        }
        Object obj = this.getInstance(classPath);
        System.out.println("obj = " + obj);
    }
}

class Persons {

    private String name;
    public  int age;

    public Persons() {
        super();
        System.out.println("Persons.Persons()");
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