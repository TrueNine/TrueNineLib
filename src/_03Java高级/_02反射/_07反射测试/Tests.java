package _03Java高级._02反射._07反射测试;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/25
 */
public class Tests {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        // 获取到类对象
        Class<T> clazz = T.class;

        // 根据此类创建对象
        T t = clazz.newInstance();

        // 扫描该类下的 public 方法
        Method[] methods = clazz.getMethods();
        // 扫描该方法是否有指定注解
        for (Method temp : methods) {
            MyTest annotation = temp.getAnnotation(MyTest.class);
            if (null != annotation) {
                // 拿到方法并执行
                temp.invoke(t);
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyTest {
    String value() default "233";
}

class T {
    @MyTest
    public void t1() {
        // 测试框架
        System.out.println("成功拿到该方法");
    }
}