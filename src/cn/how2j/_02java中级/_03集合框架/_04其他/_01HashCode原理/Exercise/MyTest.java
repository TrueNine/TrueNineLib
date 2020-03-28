package cn.how2j._02java中级._03集合框架._04其他._01HashCode原理.Exercise;

import java.util.LinkedList;

/**
 * 练习 实现 MyHashMap
 *
 * @author 彭继工
 * @version 1.0
 * @date 2020-03-28:14:31
 */
public class MyTest{
    public static void main(String[] args) {
        // 测试
        MyHashMap map = new Empty(100);

        // 插入数据
        map.put("我",new Object());
        map.put("日",new Object());
        map.put("日",new Object());

        // 测试查找数据
        System.out.println(map.get("我"));
        System.out.println(map.get("日"));
    }
}

/**
 * MyHashMap 接口
 */
interface MyHashMap {
    /**
     * 往容器内加入数据
     * String 作为 key
     * Object 作为 value
     *
     * @param key   键 String
     * @param value 值 Object
     * @return 是否重复
     */
    boolean put(String key, Object value);

    /**
     * 根据 传入的 key
     * 返回对应的 value
     * 如果重复了,进行 equals 比较
     * 返回该对象的值
     *
     * @param key 键
     * @return 内容
     */
    Object get(String key);
}

/**
 * 实现上接口
 */
class Empty implements MyHashMap {

    /**
     * 核心数组
     * 存放内容为链表
     * 该链表保存了
     */
    LinkedList<Element>[] value;

    /**
     * 空构造器
     * 初始化 maxHash 为 1024
     */
    Empty() {
        this(1024);
    }

    /**
     * 带参构造器
     * 初始化 maxHash 的长度
     *
     * @param maxHash 哈希范围
     */
    Empty(int maxHash) {
        this.maxHash = maxHash;
        this.value = new LinkedList[this.maxHash];
    }

    @Override
    public boolean put(String key, Object value) {
        // 计算 hashcode
        int hashcode = hash(key);
        boolean is = false;

        // 判断该位置是否已经存在链表,不存在则创建
        LinkedList<Element> list = this.value[hashcode];
        if (null == list) {
            list = new LinkedList<>();
            this.value[hashcode] = list;
            list.add(new Element(key,value));
            return false;
        }

        // 判断 key 是否存在
        for (Element temp : list) {
            // 如果已经存在则替换
            if (key.equals(temp.getKey())) {
                is = true;
                temp.setValue(value);
                break;
            } else {
                // 不存在则追加在链表的后方
                Element e = new Element(key,value);
                list.add(e);
            }
        }
        return is;
    }

    @Override
    public Object get(String key) {
        // 进行 hashCode 运算
        int hashcode = hash(key);

        // 定义返回的临时变量
        Element result = null;
        // 判断该位置是否有值
        LinkedList<Element> list = this.value[hashcode];
        if (null == list) {
            throw new RuntimeException("该 key 不存在");
        } else {
            boolean is = true;
            for (Element temp : list) {
                if (key.equals(temp.getKey())) {
                    result = temp;
                    is = false;
                }
            }
            if (is) {
                throw new RuntimeException("该 key 不存在");
            }
        }
        return result;
    }

    /**
     * 用于初始化 hash 的计算长度
     * 以及存储的数组长度
     */
    private int maxHash;

    /**
     * 计算 key 的 hashCode
     *
     * @param key String
     * @return hashCode
     */
    private int hash(String key) {
        return 0 == key.length() ? 0 : hash(key.toCharArray());
    }

    /**
     * 计算 hash 的重载方法
     *
     * @param cs 字符数组
     * @return hash
     */
    private int hash(char[] cs) {
        int result = 0;
        for (int i = 0; i < cs.length; i++) {
            result += cs[i];
        }
        result *= 23;
        // 不能取到最大的数组长度,必须 - 1
        result %= (maxHash - 1);
        return result;
    }
}

/**
 * 键值对存储结构
 */
class Element {

    /**
     * 键值对
     */
    private String key;
    private Object value;

    /**
     * 空构造器
     * 初始化 key value 为 null
     */
    Element() {
        this.key = null;
        this.value = null;
    }

    /**
     * 带参构造器
     * 初始化 key 和 value
     *
     * @param key   String
     * @param value Object
     */
    Element(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * set get
     */
    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Object getValue() {
        return value;
    }

    /**
     * 重写的 toString
     *
     * @return [key:xxx value:xxx]
     */
    @Override
    public String toString() {
        return "[key:" + key + " value:" + value + "]";
    }
}