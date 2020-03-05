package cn.how2j._07接口与继承._02对象转型;

import cn.how2j.Hero;
import cn.how2j._07接口与继承._03重写.TEST;

import java.util.HashMap;
import java.util.Map;

/**
 * 类作用: 测试
 * 类说明: 测试instanceof
 *
 * @author 彭继工
 * @date 2020 - 03 - 05:18:36
 */
public class Test {
    public static void main(String[] args) {
        Map <Object,Object> map = new HashMap <>();
        map.put(new Hero(),new Ad());
        map.put(new Ap(),new Hero());

        for (Object temp : map.values()) {
            if (temp instanceof Hero) {
                System.out.println(((Hero) temp).name);
            }
        }
    }
}

class Ad extends Hero {

}

class Ap extends Hero {

}

class Tr {

}

class Tr2 {

}