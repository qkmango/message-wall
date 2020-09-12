package model;

import Utils.JDBCUtils;
import entity.ChPwdEty;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @version 1.0
 * <p>更改密码的实体类</p>
 * <p>类详细介绍</p>
 * @className Chpwd
 * @author: Mango
 * @date: 2020-09-12 08:40
 */

public class ChPwd {
    public static boolean updatePassword(ChPwdEty chPwdEty) {


        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        try {
            //查询数据
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update user set `password`=? where uid=? and `password`=?");

            ps.setString(1, chPwdEty.getNewPwd());
            ps.setInt(2, chPwdEty.getUid());
            ps.setString(3, chPwdEty.getOldPwd());

            int row = ps.executeUpdate();

            conn.commit();


            //如果查询结果集中有一行数据说明email和password匹配，是否可登陆的表级改为true
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeAll(conn,ps);
        }


        return flag;


    }
}
