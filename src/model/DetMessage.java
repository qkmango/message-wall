package model;

import Utils.JDBCUtils;
import entity.MessageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * <p>获取某个message的详细信息</p>
 * <p>主界面点击查看按钮，获取某个message的详细信息，此模型层返回此条message详细信息</p>
 * @className DetMessage
 * @author: Mango
 * @date: 2020-09-13 12:08
 */
public class DetMessage {

    public static MessageInfo getDetMessage(int mid) {


        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //一条message的详细信息
        MessageInfo detMessage = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);
            ps = conn.prepareStatement("select u.uid,m.mid,m.target,m.date,m.msg,m.color,m.anony,u.nickname from message m LEFT JOIN user u on m.uid=u.uid where m.mid=?");
            ps.setInt(1,mid);
            rs = ps.executeQuery();
            if (rs.next()) {
                detMessage = new MessageInfo(
                        mid,
                        rs.getInt("uid"),
                        rs.getNString("nickname"),
                        rs.getString("target"),
                        rs.getString("date"),
                        rs.getString("msg"),
                        rs.getInt("color"),
                        rs.getInt("anony")==1
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
        }


        return detMessage;




    }
}
