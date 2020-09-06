package dataSource;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>数据库连接池工具类</p>
 * <p>静态初始化创建一个数据库连接池</p>
 * @className DataSourceUtils
 * @author: Mango
 * @date: 2020-09-06 20:17
 */
public class DataSourceUtils {
    /**
     * Druid连接池对象
     */
    private static DruidDataSource druidDataSource = new DruidDataSource();

    /**
     * 静态创建一个Druid连接池对象并通过配置文件设置相关配置
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("prop/druid");
        // DruidDataSource druidDataSource = new DruidDataSource();
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
}
