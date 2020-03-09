package cn.how2j._08数字与字符串._07操作字符串.Exercise;

/**
 * 判断多少单词以指定字符串开头
 *
 * @author 彭继工
 * @date 2020-03-09:13:13
 */
public class FirstString {
    public static void main(String[] args) {
        // 传入字符串
        String str = "peter piper picked a peck of pickled peppers";

        String[] ss = str.split(" ");

        // 进行循环判断
        int counter = 0;
        for (int i = 0; i < ss.length; i++) {
            // 取出首字母
            char tempCh = ss[i].charAt(0);

            if (Character.isLetter(tempCh)) {
                // 将首字母转换为大写,统一模糊判断
                tempCh = Character.toUpperCase(tempCh);

                if ('P' == tempCh) {
                    counter ++;
                }
            }
        }
        System.out.println("一共有: " + counter + "个");
    }
}