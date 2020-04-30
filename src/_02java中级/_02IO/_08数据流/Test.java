package _02java中级._02IO._08数据流;

import java.io.*;

/**
 * 测试读取写入文件
 * 使用数据流
 *
 * @author 彭继工
 * @date 2020-03-20:11:42
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File src = new File("src/cn/how2j/_02java中级/_02IO/_08数据流/file/w.txt");
        if (!src.exists()) {
            src.getParentFile().mkdirs();
            src.createNewFile();
        }

        write(src);
        read(src);
    }
    private static void read(File src) {
        try (FileInputStream fis = new FileInputStream(src);
             DataInputStream dis = new DataInputStream(fis)) {
            // 格式化读入数据
            boolean is = dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到数据: "
                    + is
                    + i
                    + str
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(File dest) {
        if ( ! dest.exists()) {
            dest.getParentFile().mkdirs();
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 格式化写出数据
        try (FileOutputStream fos = new FileOutputStream(dest);
             DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeBoolean(false);
            dos.writeInt(23);
            dos.writeUTF("123 23124 4234");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
