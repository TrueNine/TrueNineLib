package _03Java高级._02反射._05反射获取类结构.ttr;

import _03Java高级._02反射._05反射获取类结构.Person;
import cn.yzdz.outConsole.Print;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的所有属性结构
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/24
 */
public class FieldTest {

    /**
     * getFields() 获取类以及父类内 为 public 权限的属性
     * getDeclaredFields() 获取当前运行时类的定义属性,但不包含父类声明的属性,同时不考虑权限
     */
    @Test
    public void t1() {
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getFields();
        for(Field temp : fields) {
            System.out.println(temp);
        }

        Print.newLine("下一个测试");

        // 测试
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field temp : declaredFields) {
            System.out.println(temp);
        }
    }

    /**
     * 取出具体的属性
     */
    @Test
    public void t2() {
        Class<Person> clazz = Person.class;
        Field[] fieldDeclaredFields = clazz.getDeclaredFields();
        for(Field temp : fieldDeclaredFields) {
            // 获取权限修饰符,获取类型为 int 形式
            int modifiers = temp.getModifiers();
            System.out.print("modifiers = " + modifiers + "\t");
            // 打印权限修饰符,以字符串形式返回,默认权限没有
            System.out.print("Modifier.toString = " + Modifier.toString(modifiers) + "\t");

            // 变量的数据类型
            System.out.print("type = " + temp.getType() + "\t");
            // 获取变量的类名
            System.out.print("type.getName = " + temp.getType().getName() + "\t");

            // 变量名
            System.out.print("getName = " + temp.getName() + "\t");

            System.out.println();
        }
    }

    /**
     * 获取运行时类的方法
     * 构造器同理
     */
    @Test
    public void t3() {
        Class<Person> clazz = Person.class;

        // 获取所有的方法
        // 获取运行时类的,父类的,所有 public 权限的
        Method[] methods = clazz.getMethods();
        for (Method temp : methods) {
            System.out.println(temp);
        }

        Print.newLine("declaredMethod");

        // 获取运行时类的所有方法,但不包括父类的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method temp : declaredMethods) {
            System.out.println(temp);
        }
    }

    /**
     * 测试获取所有的构造器
     */
    @Test
    public void t4() {
        Class<Person> clazz = Person.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> temp : constructors) {
            System.out.println(temp);
        }

        // 获取所有构造器
        for (Constructor<?> temp : constructors) {
            System.out.println(temp);
        }
    }

    /**
     * 获取方法的内部结构
     */
    @Test
    public void t5() {
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Print.newLine(m.toString());

            // 1. 获取方法中的注解,针对于所有方法
            Annotation[] annotations = m.getAnnotations();
            // 获取的注解只能是 RUNTIME 修饰的注解

            Print.newLine("1.方法的注解");

            for(Annotation a : annotations) {
                System.out.println(a);
            }

            Print.newLine("2. 权限修饰符");

            // 2. 得到每个方法的权限修饰符
            int modifiers = m.getModifiers();
            System.out.println(Modifier.toString(modifiers));

            // 3.获取方法的返回值类型
            Print.newLine("3.返回值类型和返回值类型的名称");
            System.out.println(m.getReturnType());
            System.out.println(m.getReturnType().getName());

            // 4.获取方法名称
            Print.newLine("4.获取方法的名称");
            System.out.println(m.getName());

            // 5. 获取方法的形参列表
            Print.newLine("5.方法的形参");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if ( ! (0 == parameterTypes.length)) {
                int index = 0;
                for (Class<?> p : parameterTypes) {
                    index ++;
                    System.out.println(p.getName() + "_args_" + index);
                }
            }

            // 6.方法抛出的异常
            Print.newLine("6.获取方法的异常");
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if ( ! (exceptionTypes == null && exceptionTypes.length == 0)) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.println("throws: " + exceptionTypes[i].getName());
                }
            }
        }
    }
}