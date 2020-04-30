package _02java中级._07JDBC尝试_尚硅谷._05查询;

import _02java中级._07JDBC尝试_尚硅谷.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * 测试使用 PreparedStatement 查询
 * 针对于某张表的查询
 *
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/27
 */
public class Tests {

    @Test
    public void t1() throws InstantiationException, IllegalAccessException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 预编译SQL语句
            String sql = "SELECT `id`,`name`,`email`,`birth` FROM customers WHERE id = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1);

            // 执行,返回一个结果集
            result = ps.executeQuery();

            // 处理结果集
            // 判断结果集的下一条是否有数据
            if (result.next())  {
                // 获取当前这条数据的各个字段值
                int id = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                Date birth = result.getDate(4);

                // 1. 直接显示
                System.out.println(id
                        + "====="
                        + name
                        + "===="
                        + email
                        + "===="
                        + birth
                );
                // 2. 封装在数组,也不是特别好

                // 3. 直接封装为一个类的对象,ORM 关系映射
                Customers customers = new Customers(id,name,email, birth ,new Object());
                System.out.println("映射为对象: \n" + customers);
            } else {
                System.out.println("没有结果");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.closeResource(conn,ps,result);
        }
    }

    /**
     * 测试使用通用的查询
     * 以下异常统统没用
     *
     * @throws SQLException           数据库异常
     * @throws IOException            IO异常
     * @throws ClassNotFoundException 类解析异常
     */
    @Test
    public void t2() throws SQLException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String sql = "SELECT * FROM customers WHERE `id` = ?";

        Customers select = select(sql, 13);
        System.out.println(select);
    }


    public Customers select(String sql,Object... args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 连接数据库
        Connection conn = JDBCUtils.getConnection();

        // 预编译SQL语句
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1,args[i]);
        }

        // 得到结果集
        ResultSet rs = ps.executeQuery();
        // 获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        // 获取列数
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            // 创建一个映射对象
            Customers c = new Customers();
            for (int i = 0; i < columnCount; i++) {
                // 拿到该行的数据
                Object value = rs.getObject(i + 1);

                // 获取列的名称
                String name = rsmd.getColumnLabel(i + 1);

                try {
                    // 通过反射给对象赋值
                    Field f = Customers.class.getDeclaredField(name);
                    f.setAccessible(true);

                    // 设置对象的值
                    try {
                        f.set(c, value);
                    } catch (IllegalAccessException e) {
                        System.out.println("f = " + f + "此类属性赋值异常");
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    System.out.println("name = " + name + "创建此属性异常");
                    e.printStackTrace();
                }
            }
            return c;
        }
        return null;
    }
}

/**
 * orm 编程思想: 对象关系映射
 * 让一个数据表对应一个 Java 类
 * 表中的一条记录,对应 Java 类的一个对象
 * 表中的一个字段,对应 Java 类的一个属性
 */
class Customers {
    

    private int id;
    private String name;
    private String email;
    private Date birth;
    private Object photo;

    public Customers() {

    }

    public Customers(int id, String name, String email, Date birth ,Object photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.photo = photo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customers) {
            return this.id == ((Customers)obj).id;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth + '\'' +
                ", photo=" + photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public Object getPhoto() {
        return this.photo;
    }
}