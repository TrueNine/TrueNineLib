package _02java中级._02IO._03文件字节流.Exercise;

import java.io.*;

/**
 * 练习,切割文件
 *
 * @author 彭继工
 * @date 2020-03-18:12:21
 */
public class CutFile {

    static final byte b = 1;
    static final short kb = (short) (b * 1024);
    static final int mb = kb * 1024;
    static final long gb = mb * 1024;
    static final long tb = gb * 1024;

    public static void main(String[] args) {
        File f = new File("src/cn/how2j/_02java中级/_02IO/_03文件字节流/Exercise/file/cut/赌场指纹图.jpg");
        System.out.println(f.exists());
        // 进行分割操作
        cut(f,"src/cn/how2j/_02java中级/_02IO/_03文件字节流/Exercise/file/cut/cud",kb * 20);

        // 进行合并操作
        File dir = new File("src/cn/how2j/_02java中级/_02IO/_03文件字节流/Exercise/file/cut/cud");
        File file = new File("src/cn/how2j/_02java中级/_02IO/_03文件字节流/Exercise/file/cut/合并赌场指纹图.jpg");
        mergeFile(dir,file);
    }

    /**
     * 分割文件
     *
     * @param file       需要分割的文件
     * @param parentPath 分割文件放置的路径
     * @param cutSize    分割的大小
     */
    public static void cut(File file, String parentPath, int cutSize) {
        if (0 == file.length()) {
            throw new RuntimeException("文件长度是 0");
        }
        // 获取文件名,需要循环的次数
        String fileName = file.getName();
        int each;
        if (0 == cutSize % file.length()) {
            each = (int) (file.length() / cutSize);
        } else {
            each = (int) (file.length() / cutSize) + 1;
        }

        // 创建父目录
        File destDirectory = new File(parentPath);
        if (!new File(parentPath).exists()) {
            destDirectory.mkdirs();
        }

        // 将文件读入程序
        byte[] fileContent = new byte[(int) file.length()];
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fis.read(fileContent);
            fis.close();

            // 进行分段写出
            for (int i = 0; i < each; i++) {
                byte[] eachContent = null;
                // 判断是否是最后一个
                if (i != each - 1) {
                    eachContent = new byte[cutSize];
                    System.arraycopy(fileContent, i * cutSize, eachContent, 0, eachContent.length);
                } else {
                    eachContent = new byte[(int) (file.length() % cutSize)];
                    System.arraycopy(fileContent, i * cutSize, eachContent, 0, eachContent.length);
                }
                // 写出到文件
                fos = new FileOutputStream(
                        new File(parentPath, i + "-" + file.getName())
                );
                fos.write(eachContent);
                fos.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并文件
     * 按照分割的格式
     *
     * @param directory 需要合并的目录
     * @param destFile  放置的文件
     */
    public static void mergeFile(File directory, File destFile) {
        File[] folders = directory.listFiles();
        System.out.println("目标文件的大小为: " + directory.length());

        if (destFile.exists()) {
            try {
                destFile.getParentFile().mkdirs();
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 对文件数组进行排序,同时累加计算文件的大小
        for (int w = 0; w < folders.length; w++) {
            boolean flag = true;
            for (int n = 0; n < folders.length - w - 1; n++) {
                if (parseFileName(folders[n]) > parseFileName(folders[n + 1])) {
                    File temp = folders[n];
                    folders[n] = folders[n + 1];
                    folders[n + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        // 逐个写出到文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(destFile);

            for (File temp : folders) {
                byte[] bytes = new byte[(int) temp.length()];
                fis = new FileInputStream(temp);
                fis.read(bytes);

                fos.write(bytes);
                fos.flush();
            }
            // 最后关闭流
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析文件名称
     * 返回一个数值
     * 该数值是按照分割格式而解析
     *
     * @param file 文件
     * @return int
     */
    public static int parseFileName(File file) {
        // 获取该文件的名称
        String name = file.getName();


        return Integer.parseInt(
                name.split("-")[0]
        );
    }
}