package dataSource;

import java.sql.*;

/**
 * @version 1.0
 * @Description:
 * <p>JDBCUtils 工具类</p>
 * <p>是一个工具类，提供了常用的资源关闭方法</p>
 * @className JDBCUtils
 * @author: Mango
 * @date: 2020-09-06 21:22
 */
public class JDBCUtils {
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
