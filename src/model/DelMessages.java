package model;

import Utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * <p>从个人信息里面的我的留言列表中删除message，模型层</p>
 * <p>类详细介绍</p>
 * @className DelMessages
 * @author: Mango
 * @date: 2020-09-17 18:54
 */
public class DelMessages {
    public static int delMessages(String mids) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int row = 0;
        //一条message的详细信息
        // MessageInfo detMessage = null;

        try {
            String[] split = mids.split(",");
            StringBuffer sql = new StringBuffer("delete from message where mid in (");
            for (int i = 0; i<split.length; i++) {
                if (i==split.length-1) {
                    sql.append("?");
                } else {
                    sql.append("?,");
                }
            }
            sql.append(")");
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            System.out.println(sql);
            ps = conn.prepareStatement(sql.toString());
            // System.out.println(ps.get);
            for (int i = 1; i<=split.length; i++) {
                ps.setInt(i,Integer.parseInt(split[i-1]));
            }
            row = ps.executeUpdate();


        } catch (SQLException throwables) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
        }


        return row;


    }
}
