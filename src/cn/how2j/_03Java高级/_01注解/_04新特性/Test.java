package cn.how2j._03Java高级._01注解._04新特性;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/22
 */
public class Test {

    /**
     * 老的书写方式
     */
    @MyAnnotations(
            value = {@MyAnnotationsS(value = "23"),
                    @MyAnnotationsS(value = "v"),
                    @MyAnnotationsS(value = "ce23")})
    public void test1() {

    }
}


@interface MyAnnotations {
    MyAnnotationsS[] value();
}


@interface MyAnnotationsS {
    String value() default "默认值";
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_PARAMETER)
@interface ers {
    er[] value();
}

@Repeatable(ers.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_PARAMETER)
@interface er {
    String value();
}



@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@interface an {

}

class Type<@an T> {

    public void ty() throws @an RuntimeException{
        List<@an String> list = new ArrayList<>();
        int as = (@an int) 213124312412512512L;
    }
}