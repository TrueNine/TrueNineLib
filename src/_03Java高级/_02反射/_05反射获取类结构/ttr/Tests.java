package _03Java高级._02反射._05反射获取类结构.ttr;

import _03Java高级._02反射._05反射获取类结构.Person;
import cn.yzdz.outConsole.Print;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/24
 */
public class Tests {

    /**
     * 测试获取构造器
     * 其他操作跟方法类似
     */
    @Test
    public void t1() {
        Class<Person> clazz = Person.class;

        // 获取当前运行时类当中,声明为 public 的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> temp : constructors) {
            // 获取公开的构造器
            System.out.println(temp);
        }

        // 获取当前运行时类中,所有权限构造器
        Print.newLine("declared");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> temp : declaredConstructors) {
            System.out.println(temp);
        }
    }

    /**
     * 获取运行时类的父类,父类的泛型
     */
    @Test
    public void t2() {
        Class<Person> clazz = Person.class;

        // 获取父类
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        System.out.println("获取父类的泛型");

        // 获取运行时类,带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取运行时类,带泛型的父类,的泛型类型
        // 使用带参数的类型强转
        System.out.println("获取父类的泛型类型");

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // 获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type temp : actualTypeArguments) {
            System.out.println(temp);

            // 直接获取名称
            System.out.println(temp.getTypeName());

            // 不推荐的方式
            System.out.println(((Class<?>) temp).getName());
        }
    }

    /**
     * 获取运行时类,实现的接口
     */
    @Test
    public void t3() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();

        System.out.println("实现的接口");
        for(Class<?> temp : interfaces) {
            System.out.println(temp);
        }

        // 尝试拿取父类的接口,手动实现
        System.out.println("父类实现的接口");
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class<?> temp : interfaces1) {
            System.out.println(temp);
        }
    }

    /**
     * 获得运行时类所在的包
     */
    @Test
    public void t4() {
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void t5() {
        Class<?> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation temp : annotations) {
            System.out.println(temp);
        }
    }
}
