package cn.how2j._03Java高级._01注解._02自定义注释;

/**
 * 一个测试的自定义注解
 * 1. 注解需要使用 @interface 来声明
 * 2. Annotation 是以五参数方法来声明,是 ! 成员变量 !,方法和返回值
 *      如果只有一个成员变量,建议使用 value
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/22
 */
public @interface MyAnnotation {
    String value() default "指定默认值";
}

@MyAnnotation
class Test {

}