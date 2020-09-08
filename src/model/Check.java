package model;

import Utils.JDBCUtils;
import entity.MessageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className Check
 * @author: Mango
 * @date: 2020-09-08 03:53
 */
public class Check {
    public static MessageInfo getCheckForMid(int mid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MessageInfo messageInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("select mid,target,date,msg,color,anony,u.nickname,u.uid from message m LEFT JOIN user u on m.uid=u.uid WHERE m.mid=?");
            ps.setInt(1,mid);
            rs = ps.executeQuery();

            rs.next();
            messageInfo = new MessageInfo(
                    rs.getInt("mid"),
                    rs.getInt("uid"),
                    rs.getString("nickname"),
                    rs.getString("target"),
                    rs.getString("date"),
                    rs.getString("msg"),
                    rs.getInt("color"),
                    (rs.getInt("anony")==0)?true:false
            );


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
        }

        return messageInfo;

    }
}
