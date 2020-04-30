package _01java初级._08数字与字符串._08比较字符串.Exercise;

import cn.yzdz.YzdzList;
import cn.yzdz.outConsole.*;
import cn.yzdz.random.RandomString;

/**
 * 比较字符串数组内
 * 相同的 种类数量
 * 忽略大小写
 *
 * @author 彭继工
 * @date 2020-03-09:14:10
 */
public class Comparator {
    public static void main(String[] args) {
        Print<String> print = new Print<>();

        // 创建一个字符串数组,长度100,每个字符串长度为 2,包含字母和数字
        String[] stringArray = new String[100];
        RandomString randomString = new RandomString();
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = randomString.numberAndLetterAndSignAndChinese(150);
        }

        // 进行排序
        sort(stringArray);

        // 打印测试
        System.out.println(Print.line("排序好的数组"));
        print.printArray(stringArray,1);

        // 尝试使用记录法
        // 使用一个字符串数组记录已经找到的种类
        // 如若再匹配到同样的则直接跳过
        int number = kind(stringArray);

        System.out.println(Print.line("打印结果"));
        System.out.println(number);
        System.out.println(database);
    }

    /**
     * 冒泡排序法
     * 排序字符串数组
     *
     * @param stringArray 字符串数组
     * @return String[]
     */
    public static String[] sort(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            boolean flag = true;
            for (int j = 0; j < stringArray.length - i - 1; j++) {
                char before = Character.toUpperCase(stringArray[j].charAt(0));
                char after = Character.toUpperCase(stringArray[j + 1].charAt(0));
                if (before > after) {
                    String temp = stringArray[j];
                    stringArray[j] = stringArray[j + 1];
                    stringArray[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return stringArray;
    }

    /**
     * 找出一个字符串数组内有多少同种类
     *
     * @param stringArray 字符串数组
     * @return String[]
     */
    public static int kind(String[] stringArray) {
        int result = 0;
        for (int i = 0; i < stringArray.length; i++) {
            // 逐个排除 n = i
            int flag = 0;
            for (int n = i; n < stringArray.length; n++) {
                // 判断是否重复次数超过 2
                if (stringArray[i].equalsIgnoreCase(stringArray[n])) {
                    flag ++;
                    if (2 == flag) {
                        // 进入数据库查找,旗标清零
                        result += kindDatabase(stringArray[n],stringArray.length) ? 1 : 0;
                        flag = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 存放找出的数组
     */
    static YzdzList <String> database;

    /**
     * kind的附属方法
     * 用以比对是否存在
     *
     * @param s     需要查找的字符串
     * @param index 数组本来的长度
     * @return boolean
     */
    private static boolean kindDatabase(String s, int index) {
        // 第一次查找进行赋值处理
        if (null == database) {
            database = new YzdzList<>();
        }

        for (int i = 0; i < database.length(); i++) {
            if (s.equalsIgnoreCase(database.get(i))) {
                return false;
            }
        }
        database.add(s);

        return true;
    }
}