package _02java中级._07JDBC尝试_尚硅谷._04PreparedStatement操作测试;

import _02java中级._07JDBC尝试_尚硅谷.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试 preparedStatement
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/26
 */
public class Tests {



    @Test
    public void t1() throws SQLException, IOException, ClassNotFoundException {
        // 0. 提升变量作用域
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1. 获取数据库连接
            conn = JDBCUtils.getConnection();

            // 2. 预编译SQL语句,返回 preparedStatement 实例
            String sql = "UPDATE customers SET `name` = ? WHERE `id` = ?";
            // 获得 Connection 的 preparedStatement
            ps = conn.prepareStatement(sql);

            // 3. 填充SQL中的占位符 ?
            ps.setObject(1,"莫扎特");
            ps.setObject(2,18);

            // 4. 执行
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.closeResource(conn,ps);
        }
    }

    /**
     * 测试调用封装的方法,进行通用增加,删除,修改
     */
    @Test
    public void t2() throws SQLException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = "_02java中级/_07JDBC尝试_尚硅谷/sqlplus.properties";
        String sql = "UPDATE customers SET `name` = ? WHERE `id` = ?";
        JDBCUtils.update(sql,"张三",18);
    }
}