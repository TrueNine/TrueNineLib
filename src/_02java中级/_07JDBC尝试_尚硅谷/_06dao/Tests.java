package _02java中级._07JDBC尝试_尚硅谷._06dao;

import _02java中级._07JDBC尝试_尚硅谷._06dao.ORM.Customer;
import _02java中级._07JDBC尝试_尚硅谷._06dao.intterfa.CustomersDAO;
import _02java中级._07JDBC尝试_尚硅谷.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/30
 */
public class Tests {

    CustomersDAO dao = new CustomerDAO();

    /**
     * 测试插入数据
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException
     */
    @Test
    public void t() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customer c = new Customer();
            c.setName("233");
            c.setEmail("2324@qq.com");
            c.setBirth(new Date(131243124124L));
            dao.insert(conn, c);
            System.out.println("添加成功");
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}
