package model;

import Utils.JDBCUtils;
import entity.MessageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @version 1.0
 * <p>类简介</p>
 * <p>获取留言的模型</p>
 * @className Message
 * @author: Mango
 * @date: 2020-09-08 01:39
 */
public class Message {

    /**
     * 留言信息集合
     * <p>此方法查询数据库返回留言信息集合</p>
     * @param
     * @return 返回一个留言信息集合
     */
    public static LinkedList<MessageInfo> getMessageList() {
        LinkedList<MessageInfo> messageList = new LinkedList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);
            ps = conn.prepareStatement("select mid,target,date,msg,color,anony,u.nickname from message m LEFT JOIN user u on m.uid=u.uid");
            rs = ps.executeQuery();
            while (rs.next()) {
                messageList.add(new MessageInfo(
                        rs.getInt("mid"),
                        rs.getString("nickname"),
                        rs.getString("target"),
                        rs.getString("date"),
                        rs.getString("msg"),
                        rs.getInt("color"),
                        (rs.getInt("anony")==0)?true:false
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
        }

        return messageList;

    }


}
