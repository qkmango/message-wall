package test;

import com.alibaba.druid.pool.DruidDataSource;
import dataSource.DataSourceUtils;

import java.sql.Connection;
import java.util.ResourceBundle;


/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className Test
 * @author: Mango
 * @date: 2020-09-06 00:51
 */
public class Test {
    public static void main(String[] args) throws Exception {

        Connection c1 = DataSourceUtils.getConnection();
        System.out.println(c1);
        Connection c2 = DataSourceUtils.getConnection();
        System.out.println(c2);

        c1.close();


        c1 = DataSourceUtils.getConnection();
        System.out.println(c1);




    }
}
