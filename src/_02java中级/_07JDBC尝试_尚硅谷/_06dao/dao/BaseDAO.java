package _02java中级._07JDBC尝试_尚硅谷._06dao.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装了针对数据表的操作
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/30
 */
public abstract class BaseDAO {

    /**
     * 用于增删改
     *
     * @param conn 连接器
     * @param sql  SQL语句
     * @param args SQL语句参数列表
     * @return execute 的 int 返回值
     * @throws SQLException 关闭流带来的异常
     */
    public int update(Connection conn, String sql, Object... args) throws SQLException {
        // 预编译SQL
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        // 进行提交
        int result = ps.executeUpdate();
        // 关闭PreparedStatement
        if (null != ps) {
            ps.close();
        }
        // 返回操作值
        return result;
    }

    /**
     * 用于查询的方法,返回一个结果
     *
     * @param conn 连接器
     * @param type 返回类型
     * @param sql  SQL语句
     * @param args 参数列表
     * @param <T>  用于约束对象
     * @return 一条结果
     */
    public <T> T select(Connection conn, Class<T> type, String sql, Object... args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        T result = null;
        try {
            // 预编译SQL
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 获得结果集,和元数据
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获得结果集的列数,并挨个反射赋值对象
            int cont = rsmd.getColumnCount();
            // 生成相应对象,并取出数据赋值
            if (rs.next()) {
                result = type.newInstance();
                if (rs.next()) {
                    for (int i = 0; i < cont; i++) {
                        Object value = rs.getObject(i + 1);
                        // 获得别名,并赋值给对象
                        String columnLabel = rsmd.getColumnLabel(i + 1);
                        // 赋值给对象
                        Field f = result.getClass().getDeclaredField(columnLabel);
                        f.setAccessible(true);
                        f.set(result, value);
                    }
                }
            }
        } finally {
            if (null != rs) {
                rs.close();
            }
        }
        return result;
    }

    /**
     * 查询一组数据,返回一个 List
     *
     * @param type 映射类型
     * @param conn 连接器
     * @param sql  SQL语句
     * @param args SQL语句参数
     * @param <T>  对象类型
     * @return 查询结果的 list
     */
    public <T> List<T> selectList(Class<T> type, Connection conn, String sql, Object... args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 预编译SQL
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 获得结果集
            rs = ps.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            if (null != rsmd) {
                List<T> list = new ArrayList<>();
                while (rs.next()) {
                    // 获得每一列的数据,并赋值添加到 list 中
                    T result = type.newInstance();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        Object value = rs.getObject(i + 1);
                        // 获得每一列的别名,并赋值
                        String name = rsmd.getColumnLabel(i + 1);
                        Field f = type.getDeclaredField(name);
                        f.setAccessible(true);
                        f.set(result, value);
                    }
                    // 添加入集合
                    list.add(result);
                }
                return list;
            }
        } finally {
            if (null != rs) {
                rs.close();
            }
            if (null != ps) {
                ps.close();
            }
        }
        return null;
    }

    /**
     * 用于查询特殊的值
     *
     * @param conn
     * @param sql
     * @param args
     * @param <E>
     * @return
     * @throws SQLException
     */
    public <E> E getFunction(Class<E> type, Connection conn, String sql, Object... args) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 预编译SQL
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 进行查询
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } finally {
            // 关闭操作
            if (null != rs) {
                rs.close();
            }
            if (null != ps) {
                ps.close();
            }
        }
        return null;
    }
}