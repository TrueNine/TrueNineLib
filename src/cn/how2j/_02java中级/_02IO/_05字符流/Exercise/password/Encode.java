package cn.how2j._02java中级._02IO._05字符流.Exercise.password;

import java.io.*;

/**
 * 练习,加密文件
 *
 * @author 彭继工
 * @date 2020-03-19:11:22
 */
public class Encode {
    public static void main(String[] args) throws IOException {
        File f = new File("src/cn/how2j/_02java中级/_02IO/_05字符流/Exercise/password/file/UpperCase.java");
        File dest = new File("src/cn/how2j/_02java中级/_02IO/_05字符流/Exercise/password/file/目标文件.txt");
        File dePassword = new File("src/cn/how2j/_02java中级/_02IO/_05字符流/Exercise/password/file/解密文件.txt");
        if ( ! dest.exists()) {
            dest.getParentFile().mkdirs();
            boolean is = dest.createNewFile();
        }
        if ( ! dePassword.exists()) {
            dePassword.getParentFile().mkdirs();
            boolean is = dePassword.createNewFile();
        }
        // 测试加密文件
        encodeFile(f, dest);
        // 测试解密文件
        dePasswordFile(dest,dePassword);
    }
    public static <fw> void encodeFile(File sourcesFile, File targetFile) {
        // 以字符形式读取到内存
        try (FileReader fr = new FileReader(sourcesFile);FileWriter fw = new FileWriter(targetFile)) {

            char[] element = new char[(int) sourcesFile.length()];
            int len = fr.read(element);

            // 进行加密操作
            for (int i = 0; i < element.length; i++) {
                element[i] = encryption(element[i]);
            }
            // 写出到目标文件
            fw.write(element);
            fw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char encryption(char ch) {
        if ( ! Character.isLetterOrDigit(ch)) {
            return ch;
        } else {
            // 如果超过 byte 的范围,则不进行计算
            if (ch > Byte.MAX_VALUE) {
                return ch;
            }
            char result;
            switch (ch) {
                case '9':
                    result = '0';
                    break;
                case 'z':
                    result = 'a';
                    break;
                case 'Z':
                    result = 'A';
                    break;
                default:
                    result = (char) (ch + 1);
            }
            return result;
        }
    }
    public static void dePasswordFile(File sources,File targetFile) throws IOException {
        FileReader fr = new FileReader(sources);
        FileWriter fw = new FileWriter(targetFile);

        // 读取到内存
        char[] element = new char[(int) sources.length()];
        int len = fr.read(element);
        fr.close();
        for (int i = 0; i < element.length; i++) {
            element[i] = deCh(element[i]);
        }

        // 写出到文件
        fw.write(element);
        fw.flush();
        fw.close();
    }
    private static char deCh(char ch) {
        if ( ! Character.isLetterOrDigit(ch)) {
            return ch;
        } else {
            if (ch > Byte.MAX_VALUE) {
                return ch;
            }
            char result;
            switch (ch) {
                case '0':
                    result = '9';
                    break;
                case 'a':
                    result = 'z';
                    break;
                case 'A':
                    result = 'Z';
                    break;
                default:
                    result = (char) (ch - 1);
            }
            return result;
        }
    }
}