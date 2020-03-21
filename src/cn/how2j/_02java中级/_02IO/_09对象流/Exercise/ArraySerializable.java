package cn.how2j._02java中级._02IO._09对象流.Exercise;

import org.junit.Test;

import java.io.*;

/**
 * 练习,将数组序列化到文件内
 * 在数组内的元素,必须实现 Serializable
 *
 * @author 彭继工
 * @date 2020-03-20:15:43
 */
public class ArraySerializable {

    @Test
    public void inPut() throws IOException, ClassNotFoundException {
        // 准备一个对象数组,使用 Hero,初始化该数组
        Hero[] h = new Hero[10];
        for (int i = 0; i < h.length; i++) {
            h[i] = new Hero("张三",i);
        }

        // 将数组序列化存入文件
        File f = new File("src/cn/how2j/_02java中级/_02IO/_09对象流/file/Object.myxml");
        if ( ! f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }

        // 创建流,写出到文件
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(f)
        );
        // 数组好像也是可以写入文件的
        // 但不能查看是否有实现 Serializable
        oos.writeObject(h);

        // 从文件读取内容
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f)
        );
        Object obj = ois.readObject();
        Hero[] hr = null;
        if (obj instanceof Hero[]) {
            hr = (Hero[]) obj;
        }

        assert hr != null;
        for (Hero temp : hr) {
            System.out.println(temp.name + temp.hp);
        }
    }
}

class Hero implements Serializable {
    String name;
    double hp;
    public Hero() {

    }
    public Hero(String name,double hp) {
        this.name = name;
        this.hp = hp;
    }
}