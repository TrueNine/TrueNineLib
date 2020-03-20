package test.yzdz;

import org.junit.*;

/**
 * 练习,移除注释
 *
 * @author 彭继工
 * @date 2020-03-19:14:30
 */
public class DeleteDoc {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            int counter = 100;
            for (int i = 0; i <= counter; i++) {
                Thread.sleep(122);
                System.out.printf("文件传输进度: %d%% ", i);
                int index = i / 10;
                System.out.print("<");
                for (int j = 0; j < counter / 10; j++) {
                    System.out.print(
                            j < i / 10 ? "=" : "-"
                    );
                }
                System.out.print(">");
                System.out.print("\r");
            }
        }
    }

    private static String str() {
        String strs = "213124";
        Assert.assertEquals(strs,"12");
        return strs;
    }
}
