package _02java中级._07JDBC尝试_尚硅谷.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/29
 */
public class JDBCUtils {

    public static Connection getConnection() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String path = "cn\\how2j\\_02java中级\\_07JDBC尝试_尚硅谷\\sqlplus.properties";
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(path);

        // 加载配置文件
        Properties p = new Properties();
        p.load(is);

        // 获取连接数据
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        String driverClass = p.getProperty("DriverClass");

        // 加载驱动,并返回连接
        Class.forName(driverClass).newInstance();
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet result) {
        if (null != result) {
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 调用方法禁止操作
        closeResource(conn, ps);
    }

    public static void closeResource(Connection conn, Statement ps) {
        if (null != ps) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void update(String sql, Object... args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        // 获取连接,预编译SQL
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        conn.setAutoCommit(false);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1,args[i]);
        }
        ps.addBatch();
        ps.executeBatch();

        // 提交清空并执行
        ps.clearBatch();

        conn.commit();
        conn.setAutoCommit(true);

        // 关闭资源
        JDBCUtils.closeResource(conn,ps);
    }
}
