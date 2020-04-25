package cn.how2j._03Java高级._02反射._05反射获取类结构;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/24
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
