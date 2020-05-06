package _02java中级._07JDBC尝试_尚硅谷._06dao;

import _02java中级._07JDBC尝试_尚硅谷._06dao.ORM.Customer;
import _02java中级._07JDBC尝试_尚硅谷._06dao.dao.BaseDAO;
import _02java中级._07JDBC尝试_尚硅谷._06dao.intterfa.CustomersDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO 接口实现类
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/30
 */
public class CustomerDAO extends BaseDAO implements CustomersDAO {
    /**
     * 添加数据,根据对象
     *
     * @param conn 连接器
     * @param c    对象
     */
    @Override
    public void insert(Connection conn, Customer c) {
        String sql = "insert into customers(`name`,`email`,`birth`) values(?,?,?);";
        try {
            update(conn, sql,
                    c.getName(),
                    c.getEmail(),
                    c.getBirth());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 用于删除数据
     *
     * @param conn 连接器
     * @param id   根据此 id 删除数据
     */
    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?;";
        try {
            update(conn, sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 根据对象更新数据
     *
     * @param conn 连接器
     * @param c    对象
     */
    @Override
    public void update(Connection conn, Customer c) {
        String sql = "update customers set `name` = ?,`email` = ?,`birth` = ? where id = ?";
        try {
            update(conn, sql,
                    c.getName(),
                    c.getEmail(),
                    c.getBirth(),
                    c.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 根据 id 修改为指定的对象
     *
     * @param conn 连接器
     * @param id   id
     * @param c    新的对象
     */
    @Override
    public void updateById(Connection conn, int id, Customer c) {
        String sql = "update customers set `name` = ?,`email` = ?,`birth` = ? where id = ?";
        try {
            update(conn, sql,
                    c.getName(),
                    c.getEmail(),
                    c.getBirth(),
                    c.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 根据 id 查询指定的 对象
     *
     * @param conn 连接器
     * @param id   id
     * @return 对象
     */
    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select `name`,`email`,`birth` from customers where id = ?;";
        try {
            return select(conn, Customer.class, sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询表中的所有记录
     *
     * @param conn 连接器
     * @return list 集合
     */
    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select * from customers;";
        try {
            return selectList(Customer.class, conn, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询表中的字段数量
     *
     * @param conn 连接器
     * @return 数量
     */
    @Override
    public long getCount(Connection conn) {
        String sql = "select concat(*) from customers";
        try {
            return getFunction(Long.class, conn, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 返回最大生日
     *
     * @param conn 连接器
     * @return SQL时间
     */
    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        try {
            return select(conn, Date.class, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}