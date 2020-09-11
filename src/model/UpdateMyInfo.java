package model;

import Utils.JDBCUtils;
import entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className UpdateMyInfo
 * @author: Mango
 * @date: 2020-09-10 15:16
 */
public class UpdateMyInfo {
    public static boolean toUpdateMyInfo(UserInfo updateUserInfo) {

        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        System.out.println("UpdateMyInfo");

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update user set nickname=?,sex=?,birthday=?,qq=?,tel=?,hide=? where uid=?");

            ps.setString(1,updateUserInfo.getNickname());
            ps.setInt(2,updateUserInfo.getSex());
            ps.setString(3,updateUserInfo.getBirthday());
            ps.setString(4,updateUserInfo.getQq());
            ps.setString(5,updateUserInfo.getTel());
            ps.setString(6,updateUserInfo.getHide());
            ps.setInt(7,updateUserInfo.getUid());

            //
            int count = ps.executeUpdate();
            conn.commit();
            if (count == 1) {
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
            JDBCUtils.closeAll(conn,ps);
        }


        return flag;



    }
}
