package _01java初级._05数组._03排序;

/**
 * 类作用: 测试
 * 类说明: 测试冒泡排序和选择排序
 *
 * @author 彭继工
 * @date 2020 - 02 - 28:15:12
 */
public class Ar {
    public static void main(String[] args) {
        // 选择排序
        int[] a = {2,1,9,8,7};

        // 打印测试
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        // 开始排序,选择排序
        for (int w = 0; w < a.length; w++) {
            for (int n = w; n < a.length; n++) {
                if (a[w] > a[n]) {
                    int temp = a[n];
                    a[n] = a[w];
                    a[w] = temp;
                }
            }
        }

        // 打印结果
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        // 开始排序,冒泡排序
        int[] b = {2,1,9,8,7};


        // 打印结果
        System.out.println();
        for (int w = 0; w < b.length; w++) {
            for (int n = 0; n < b.length - w - 1; n++) {
                if (b[n] > b[n + 1]) {
                    int temp = b[n];
                    b[n] = b[n + 1];
                    b[n + 1] = temp;
                }
            }
        }

        // 打印测试
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
