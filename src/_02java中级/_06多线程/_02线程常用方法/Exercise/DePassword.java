package _02java中级._06多线程._02线程常用方法.Exercise;

import cn.yzdz.random.RandomChar;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 使用多线程测试穷举密码
 * 创建一条破解线程用于往容器内添加破解的密码
 * 创建一条守护线程,用于从容器中取出要破解的密码
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/1
 */
public class DePassword {
    public static void main(String[] args) {
        // 开始测试
        DeCode code = new DeCode();

        // 循环生成 max 个随机密码
        int max = 3;
        char[] arr = new char[max];
        RandomChar random = new RandomChar();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.letter();
        }

        // 调用修饰方法
        code.deCode(arr);
    }
}

/**
 * 将破解线程和日志线程进行包装
 * 方便调用
 */
class DeCode {

    /**
     * 修饰方法
     * 用于开辟新线程
     * 每个单独的密码位,开辟一条线程
     *
     * @param codes 要破解的密码
     */
    public void deCode(char[] codes) {
        // 获取要破解的密码,进行循环暴力破解
        int index = 0;
        for (Character temp : codes) {
            // 传入密码和索引,启动一条线程用于破解密码
            // 设置索引
            index += 1;
            DePasswordThread d = new DePasswordThread();
            d.setIndex(index);
            d.setCode(temp);
            // 开启线程
            new Thread(d,"破解线程" + index).start();
        }
    }
}

/**
 * 破解线程
 */
class DePasswordThread implements Runnable {
    /**
     * 核心容器,用于存放已经尝试过的密码
     * 对象为安全容器
     */
    private static List<Character> value = new CopyOnWriteArrayList<>();
    private int code;
    private int index;

    /**
     * 私有构造器
     */
    public DePasswordThread() {
        // 将日志线程设置为守护线程,并启动
        Thread log = new Thread(new LogThread(),"守护线程");
        log .setDaemon(true);
        log.start();
    }

    /**
     * 私有构造器,提供密码
     *
     * @param code 密码
     */
    public DePasswordThread(int code) {
        this.code = code;
    }

    /**
     * 使用静态内部类单例返回对象
     */
    @Deprecated
    private static class getInstance {
        private static final DePasswordThread object = new DePasswordThread();
    }
    public static DePasswordThread getInstance() {
        return getInstance.object;
    }

    /**
     * 重写的多线程方法
     */
    @Override
    public void run() {
        // 调用方法去破解
        deCode();
    }

    /**
     * 用于设置需要破解的密码
     * 第几位 和 需要破解的密码
     *
     * @param index 密码位数
     */
    public void setIndex(int index) {
        this.index = index;
    }
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 用于破解密码,单个
     */
    public void deCode() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            char testChar = (char) i;
            // 往容器内推送
            this.value.add(testChar);
            if (testChar == this.code) {
                System.out.println(
                        "找到第 " + this.index + " 位密码是: "
                        + testChar
                        + " 此次结束"
                );
                break;
            }
        }
    }

    /**
     * 从当前容器中取出数据
     * 使用 synchronized 锁住
     *
     * @return 容器的第 0 个位置的数据
     */
    public static synchronized int getValue() {
        // 从容器中取出
        int result = -1;
        if ( ! value.isEmpty()) {
            result = value.remove(0);
        }
        return result;
    }
}

/**
 * 日志线程
 * 此线程开启为守护线程
 */
class LogThread implements Runnable {

    /**
     * 多线程打印
     */
    @Override
    public void run() {
        logPrint();
    }

    /**
     * 用于打印密码破解线程尝试过的密码
     * 从 破解线程的容器中取出密码
     * 如果空了则暂停一段时间,防止泄露
     */
    private void logPrint() {
        while (true) {
            int result = DePasswordThread.getValue();
            if (-1 != result) {
                System.out.println("尝试密码:" + (char) result + " |");
            } else {
                // 否则等待 半秒
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}