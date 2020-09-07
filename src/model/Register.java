package model;

import Utils.JDBCUtils;
import entity.UserLRInfo;
import exception.UniqueException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description:
 * <p>注册类</p>
 * <p>判断用户是否可注册的类，提供了canRegister()静态静态方法判断是否可注册</p>
 * @className Register
 * @author: Mango
 * @date: 2020-09-07 10:21
 */
public class Register {
    /**
     * 是否可注册
     * <p>通过传入的参数查询数据库判断是否可注册，如果email唯一性约束重复，则不可注册</p>
     * @param userLRInfo 参数说明
     * @return -1，email重复；1 注册成功
     */
    public static int canRegister(UserLRInfo userLRInfo) {

        //是否可注册的标记flag
        int flag = -1;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //查询数据
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("insert into user(email,password) values(?,?)");
            ps.setString(1, userLRInfo.getEmail());
            ps.setString(2, userLRInfo.getPassword());
            int i = ps.executeUpdate();
            conn.commit();
            //如果查询结果集中有一行数据说明email和password匹配，是否可登陆的表级改为true
            if (i == 1) {
                flag = 1;
            }
        } catch (SQLException throwables) {
            //如果有异常则回滚
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            //关闭资源
            JDBCUtils.closeAll(conn,ps);
        }

        //返回-1则插入失败，喂一性约束异常
        return flag;
    }
}
