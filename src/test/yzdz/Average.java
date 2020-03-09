package test.yzdz;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入若干数值
 * 取中间值
 *
 * @author 随
 * @date 2020-03-08:21:45
 */
public class Average {

    private int[] array;
    int pointer;

    public static void main(String[] args) {
        // 实例化当前对象
        Average average = new Average();

        // 创建一个数组,循环读入
        Scanner scanner = new Scanner(System.in);

        // 死循环,判断输入 0 退出
        while (true) {
            System.out.print("请输入数值,输入 0 退出:\t");
            int tempNumber = scanner.nextInt();
            if (0 != tempNumber) {
                average.add(tempNumber);
            } else {
                break;
            }
        }

        // 测试打印
        System.out.println("您输入的数据为");
        System.out.println(Arrays.toString(average.array));

        // 对数组进行排序,使用冒泡排序法
        average.sort();
        System.out.println(Arrays.toString(average.array));

        // 取中间值,array.length / 2
        System.out.println("您所有数据的中间值是: "
            + average.array[average.array.length / 2]
        );
    }

    /**
     * 实现动态数组
     * 使用 System.arrayCopy
     * 每次添加,复制数组
     * 数组为 null 则 赋初值
     *
     * @param number 添加的元素
     */
    public void add(int number) {
        // array 没有内容,进行初始化
        if (null == this.array) {
            this.array = new int[1];
            this.pointer = 0;
            // 进行赋值
            this.array[pointer] = number;
            // 指向下一个索引
            this.pointer ++;
            return;
        }

        // 声明一个比原先数组长的数组
        int[] tempArr = new int[array.length + 1];

        tempArr[pointer] = number;

        // 进行数组复制
        System.arraycopy(this.array,0,tempArr,0,this.array.length);

        // 将新增的值新增进数组
        tempArr[pointer] = number;
        pointer ++;

        // 将 this.array 指向新的数组
        this.array = tempArr;
    }

    /**
     * 排序方法
     * 对维护的 array 数组进行排序
     * 使用冒泡排序法
     */
    public void sort() {
        boolean isBreak = true;
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    int temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;

                    isBreak = false;
                }
                if (isBreak) {
                    break;
                }
            }
        }
    }
}