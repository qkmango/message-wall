package model;

import Utils.JDBCUtils;
import entity.MessageInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className AddMessage
 * @author: Mango
 * @date: 2020-09-08 20:08
 */
public class AddMessage {
    public static boolean addMessage(MessageInfo messageInfo) {

        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("insert into message(uid,target,date,msg,anony,color) values(?,?,?,?,?,?)");

            ps.setInt(1,messageInfo.getUid());
            ps.setString(2,messageInfo.getTarget());
            ps.setString(3,messageInfo.getDate());
            ps.setString(4,messageInfo.getMsg());
            ps.setInt(5,messageInfo.isAnony()?1:0);
            //判断 主题颜色如果通过非法提交超出范围，那么就默认为1
            ps.setInt(6,((messageInfo.getColor()<=5 && messageInfo.getColor()>=1)?messageInfo.getColor():1));

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
