package model;

import Utils.JDBCUtils;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className ChAvatar
 * @author: Mango
 * @date: 2020-09-12 21:29
 */

public class ChAvatar {
    public static boolean chAvatar(String avatar, int uid) {



        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        try {
            //查询数据
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update user set `avatar`=? where uid=?");
            ps.setString(1,avatar);
            ps.setInt(2,uid);

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
