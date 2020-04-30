package _01java初级._08数字与字符串._03Math类.Exercise;

/**
 * 统计一千万以内
 * 有多少质数
 *
 * @author 彭继工
 * @date 2020-03-08:16:48
 */
public class PrimeNumber {
    public static void main(String[] args) {
        // 定义一个 一千万
        int max = 100;

        int counter = 0;
        for (int i = 1; i <= max; i++) {
            if (isPrime(i)) {
                counter ++;
            }
        }

        System.out.println(counter);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            System.out.println(Math.sqrt(n));
            if (0 == n % i) {
                return false;
            }
        }
        return true;
    }
}