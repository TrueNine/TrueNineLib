package _02java中级._07JDBC尝试_尚硅谷._06dao.intterfa;

import _02java中级._07JDBC尝试_尚硅谷._06dao.ORM.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * 定义customers 表的操作规范
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/30
 */
public interface CustomersDAO {
    /**
     * 添加数据,根据对象
     *
     * @param conn 连接器
     * @param c    对象
     */
    void insert(Connection conn, Customer c);

    /**
     * 用于删除数据
     *
     * @param conn 连接器
     * @param id   根据此 id 删除数据
     */
    void deleteById(Connection conn, int id);

    /**
     * 根据对象更新数据
     *
     * @param conn 连接器
     * @param c 对象
     */
    void update(Connection conn, Customer c);

    /**
     * 根据 id 修改为指定的对象
     *
     * @param conn 连接器
     * @param id   id
     * @param c    新的对象
     */
    void updateById(Connection conn, int id, Customer c);

    /**
     * 根据 id 查询指定的 对象
     *
     * @param conn 连接器
     * @param id   id
     * @return 对象
     */
    Customer getCustomerById(Connection conn, int id);

    /**
     * 查询表中的所有记录
     *
     * @param conn 连接器
     * @return list 集合
     */
    List<Customer> getAll(Connection conn);

    /**
     * 查询表中的字段数量
     *
     * @param conn 连接器
     * @return 数量
     */
    long getCount(Connection conn);

    /**
     * 返回最大生日
     *
     * @param conn 连接器
     * @return SQL时间
     */
    java.sql.Date getMaxBirth(Connection conn);
}