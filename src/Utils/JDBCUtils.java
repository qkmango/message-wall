package Utils;

import java.sql.*;
import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @version 1.0
 * @Description:
 * <p>JDBCUtils 工具类</p>
 * <p>是一个工具类，提供了数据库连接池和常用的资源关闭方法</p>
 * @className JDBCUtils
 * @author: Mango
 * @date: 2020-09-06 21:22
 */
public class JDBCUtils {

    /**
     * Druid连接池对象
     */
    private static DruidDataSource druidDataSource = new DruidDataSource();

    /**
     * 静态创建一个Druid连接池对象并通过配置文件设置相关配置
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("prop/druid");
        druidDataSource.setDriverClassName(bundle.getString("driverClassName"));
        druidDataSource.setUrl(bundle.getString("url"));
        druidDataSource.setUsername(bundle.getString("username"));
        druidDataSource.setPassword(bundle.getString("password"));
        druidDataSource.setInitialSize(Integer.parseInt(bundle.getString("initialSize")));
        druidDataSource.setMaxActive(Integer.parseInt(bundle.getString("maxActive")));
        druidDataSource.setMaxActive(Integer.parseInt(bundle.getString("maxWait")));
    }

    /**
     * 获取连接
     * <p>从druid连接池中获取一个连接</p>
     * @param
     * @return 返回一个Connection连接对象
     */
    public static Connection getConnection() throws SQLException {
        return druidDataSource.getConnection();
    }

    /**
     * 关闭连接和资源
     * <p>关闭Connection连接、关闭PreparedStatement预编译SQL语句对象、关闭ResultSet查询结果集</p>
     * @param conn 数据库连接对象
     * @param ps 预编译SQL语句对象
     * @param rs 查询结果集
     * @return void
     */
    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接和资源
     * <p>关闭Connection连接、关闭PreparedStatement预编译SQL语句对象</p>
     * @param conn 数据库连接对象
     * @param ps 预编译SQL语句对象
     * @return void
     */
    public static void closeAll(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     * <p>关闭数据库连接对象conn</p>
     * @param conn 数据连接对象
     * @return void
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭statement
     * <p>关闭数据库连接对象conn</p>
     * @param statement statement对象
     * @return void
     */
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭ResultSet查询结果集
     * <p>关闭查询结果集对象ResultSet rs</p>
     * @param rs 查询结果集
     * @return void
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
