package _02java中级._03集合框架._01ArrayList._04支持泛型的集合.Exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习 设计一个 ArrayList
 * 既可以存放 Hero 又可以存放 Item
 *
 * 让 Hero 和 Item 都实现一个空接口
 *
 * @author 彭继工
 * @date 2020-03-22:12:27
 */
public class Lists {
    @Test
    public void test() {
        List<LOL> lists = new ArrayList<>();
    }
}

class Hero implements LOL{

}
class Item implements LOL{

}

interface LOL {

}