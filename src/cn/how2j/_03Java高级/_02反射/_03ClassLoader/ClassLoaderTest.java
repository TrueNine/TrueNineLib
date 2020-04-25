package cn.how2j._03Java高级._02反射._03ClassLoader;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/23
 */
public class ClassLoaderTest {

    /**
     * 使用 ClassLoader 读取配置文件测试
     */
    @Test
    public void test1() throws IOException {
        Properties p = new Properties();;
        FileInputStream is = new FileInputStream(
                new File("src/cn/how2j/_03Java高级/_02反射/_03ClassLoader/test.properties")
        );
        // 读取配置文件
        p.load(is);

        // 读取

        String name = p.getProperty("name");
        String password = p.getProperty("password");

        System.out.println("name = " + name);
        System.out.println("password = " + password);
    }

        /**
         * 测试第二种读取方式
         */
        @Test
        public void test2() {
            ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
            // 以流的方式获取资源,使用 try with resources
            // 此处配置文件路径,相对路径默认识别为当前 module 下的 src
            try (InputStream is = classLoader.getResourceAsStream("cn/how2j/_03Java高级/_02反射/_03ClassLoader/test.properties")) {
                Properties p = new Properties();
                p.load(is);

                // 尝试获取
                String name = p.getProperty("name");
                String password = p.getProperty("password");

                System.out.println("name = " + name);
                System.out.println("password = " + password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
