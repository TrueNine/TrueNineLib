package _02java中级._07JDBC尝试_尚硅谷._01连接数据库;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 测试连接数据库
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/8
 */
public class Tests {

    /**
     * 第一种连接方式
     * 高耦合连接方式
     */
    @Test
    public void t1(){
        // mysql的地址
        String url = "jdbc:mysql://localhost:3306/jdbc";
        // mysql 一些信息
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password","root");

        try {
            // 此处直接调用 com.mysql
            Driver driver = new com.mysql.jdbc.Driver();

            // 获取链接
            Connection c = driver.connect(url, properties);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 使用反射,动态获取连接
     */
    @Test
    public void t2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        // 获得一个动态的 mysql 驱动
        Class<?> c = Class.forName("com.mysql.jdbc.Driver");
        // 获取运行时类的对象,创建连接
        Driver driver = (Driver) c.newInstance();

        // 提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/MyEmployees";

        // 提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");

        Connection connection = driver.connect(url,info);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select last_name from  employees;");

        System.out.println(resultSet);

        resultSet.close();
        connection.close();
    }

    /**
     * 第三种注册驱动的方式
     */
    @Test
    public void t3() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Properties info = new Properties();
        info.load(new FileInputStream(new File("src/cn/how2j/_02java中级/_07JDBC尝试_尚硅谷/_01连接数据库/sql.properties")));

        // 获取 Driver 实现类对象
        Class<?> clazz = Class.forName(info.getProperty("jdbc"));
        Driver driver = (Driver) clazz.newInstance();

        // 提供获取连接的基本信息
        // url
        // user,password
        String url = info.getProperty("databaseType")
                + info.getProperty("url")
                + info.getProperty("port")
                + info.getProperty("database");
        String user = info.getProperty("user");
        String password = info.getProperty("password");

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    /**
     * 第四种加载方式
     * mysql 独有的加载方式,可以省略 Class.forName();
     * 可以只是加载驱动,不用显式注册驱动
     */
    @Test
    public void t4() throws SQLException, ClassNotFoundException, IOException {
        Properties info = new Properties();
        info.load(new FileInputStream(new File("src/cn/how2j/_02java中级/_07JDBC尝试_尚硅谷/_01连接数据库/sql.properties")));

        // 获取 Driver 实现类对象
        Class.forName(info.getProperty("jdbc"));

        // 提供获取连接的基本信息
        // url
        // user,password
        String url = info.getProperty("databaseType")
                + info.getProperty("url")
                + info.getProperty("port")
                + info.getProperty("database");
        String user = info.getProperty("user");
        String password = info.getProperty("password");

        // 相较于以上方式,省略了上述操作
        /*
        在 MySQL 的 Driver 实现类中,声明了一个静态加载操作
         */

        // 获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    /**
     * 最终推荐的连接方式
     *
     * 1. 实现代码和数据分离
     * 2. 修改配置文件,不需要对程序进行再次打包
     */
    @Test
    public void t5() {
        // 1. 读取配置文件信息
        // 获取类加载器
        try (InputStream is = Tests.class.getClassLoader().getResourceAsStream("cn\\how2j\\_02java中级\\_07JDBC尝试_尚硅谷\\_01连接数据库\\sqlplus.properties")) {
            // 加载配置文件
            Properties info = new Properties();
            info.load(is);

            // 获取配置文件内对应的配置信息
            String driverClass = info.getProperty("DriverClass");
            String url = info.getProperty("url");
            String user = info.getProperty("user");
            String password = info.getProperty("password");

            // 通过 Class.forName() 加载驱动
            Class.forName(driverClass);
            // 获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println("加载配置文件失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("获取连接失败");
            throwables.printStackTrace();
        }
    }
}
