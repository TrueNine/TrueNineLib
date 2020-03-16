package cn.how2j._02java中级._01异常._05自定义异常;

/**
 * 测试自定义异常
 *
 * @author 彭继工
 * @date 2020-03-16:10:35
 */
public class Test {
    public static void main(String[] args) {
        // 测试父类构造器
        try {
            throw new IndexOutException("我");
        } catch (IndexOutException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 自定义异常测试
 */
class IndexOutException extends Exception {
    /**
     * 空构造器
     */
    IndexOutException() {

    }

    /**
     * 提供构造器
     * 调用父类构造器
     *
     * @param msg 字符串参数
     */
    IndexOutException(String msg) {
        // 调用父类构造器
        super(msg);
    }
}
