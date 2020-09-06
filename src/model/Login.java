package model;

import dataSource.DataSourceUtils;
import dataSource.JDBCUtils;
import entity.UserLoginInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description:
 * <p>登陆类</p>
 * <p>判断用户是否可登陆的类，提供了canLogin()静态静态方法判断是否可登陆</p>
 * @className LoginServlet
 * @author: Mango
 * @date: 2020-09-05 22:39
 */
public class Login {

    /**
     * 判断用户是否可登陆
     * <p>show 方法的详细说明第一行</p>
     * @param userLoginInfo 用户登陆信息类
     * @return 如果email和password匹配则返回true，否则返回false
     */
    public static boolean canLogin(UserLoginInfo userLoginInfo) {
        //是否可登陆的标记flag
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //查询数据
            conn = DataSourceUtils.getConnection();
            ps = conn.prepareStatement("select email from user where email=? && password=?");
            ps.setString(1,userLoginInfo.getEmail());
            ps.setString(2,userLoginInfo.getPassword());
            rs = ps.executeQuery();
            //如果查询结果集中有一行数据说明email和password匹配，是否可登陆的表级改为true
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeAll(conn,ps,rs);
        }

        //返回是否可登陆的标记
        return flag;
    }
}
