package _03Java高级._02反射._06调用运行时类的结构;

import _03Java高级._02反射._05反射获取类结构.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/24
 */
public class Tests {

    /**
     * 调用指定的属性
     *
     * set 参数1: 指明设置哪个对象的属性
     * set 参数2: 将属性设置为指定的值
     */
    @Test
    public void t1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;

        // 创建运行时对象
        Person p = clazz.newInstance();

        // 获取指定的属性,要求权限为 public,通常不采用此方式
        Field id = clazz.getField("id");

        // 设置当前属性的值
        id.set(p,1001);
        // 获取当前属性值,获取哪个对象的当前属性值
        int i = (Integer) id.get(p);
        System.out.println(i);

        // 突破权限的方式,通过 DeclaredField , 获取指定变量名的 Field
        Field name = clazz.getDeclaredField("name");
        // 必须在改变值之前设置为 Accessible 为 true
        name.setAccessible(true);
        name.set(p,"张三");
        String nameR = (String) name.get(p);
        System.out.println(nameR);
    }

    /**
     * 操作运行时类中的指定方法
     * invoke 方法的返回值,及对应类中的同名方法的返回值
     *
     * getMethod 参数1: 方法名称
     * getMethod 参数2: 传参 运行时类类型
     *
     * invoke 参数1: 方法的调用者
     * invoke 参数2: 方法的实参
     */
    @Test
    public void t2() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();


        // 获取指定的某个方法
        Method show = clazz.getDeclaredMethod("show", String.class);
        // 也需要设置为可调用,保证方法可以在外部访问
        show.setAccessible(true);

        // 使用 invoke 调用
        // 同时也可以接受返回值
        Object value = show.invoke(p,"CN");
    }

    /**
     * 测试调用静态方法
     * 如果调用的方法没有返回值,则返回 null
     * 静态属性同理
     */
    @Test
    public void t3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        Object returns = showDesc.invoke(Person.class);
        System.out.println(returns);
    }

    /**
     * 调用运行时类中的构造器
     */
    @Test
    public void t4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;
        // 1. 获取指定的构造器,给与指定的形参
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        // 2. 保证构造器是可访问的
        constructor.setAccessible(true);

        // 3. 调用构造器创建运行时类的对象
        // 默认返回 Object,可以规定泛型
        Person person = constructor.newInstance("李四");

        System.out.println(person);
    }
}