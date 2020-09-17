package model;

import Utils.JDBCUtils;
import entity.MessageInfo;
import entity.PageMessageList;

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
    public static PageMessageList pageMessageListAll(int pageNum) {


        //默认在用户个人信息页面中获取其发布的message，默认每页有15个message
        PageMessageList pageMessageList = new PageMessageList(pageNum,8);
        LinkedList<MessageInfo> messageList = pageMessageList.getMessageList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = -1;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);

            //分页查询数据
            ps = conn.prepareStatement("select SQL_CALC_FOUND_ROWS u.uid,m.mid,m.target,m.date,m.msg,m.color,m.anony,u.nickname from message m LEFT JOIN user u on m.uid=u.uid order by m.mid desc limit ?,8");
            ps.setInt(1,pageMessageList.getIndex());
            rs = ps.executeQuery();
            while (rs.next()) {
                messageList.add(new MessageInfo(
                        rs.getInt("mid"),
                        rs.getInt("uid"),
                        rs.getString("nickname"),
                        rs.getString("target"),
                        rs.getString("date"),
                        rs.getString("msg"),
                        rs.getInt("color"),
                        rs.getInt("anony")
                ));
            }

            //获取总条数，此函数FOUND_ROWS()可以查询到上条语句如果不使用limit所返回的条数
            ps = conn.prepareStatement("select FOUND_ROWS() count");
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            // System.out.println("count = "+count);

            pageMessageList.setAllRowCount(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
        }

        return pageMessageList;

    }



    /**
     * 留言信息集合
     * <p>此方法通过uid作为条件查询数据库返回留言信息集合</p>
     * @param
     * @return 返回一个留言信息集合
     */
    public static PageMessageList pageMessageListFromUid(int pageNum, int uid) {


        //默认在用户个人信息页面中获取其发布的message，默认每页有15个message
        PageMessageList pageMessageList = new PageMessageList(pageNum, 15);
        LinkedList<MessageInfo> messageList = pageMessageList.getMessageList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = -1;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);

            //分页查询数据
            ps = conn.prepareStatement("select SQL_CALC_FOUND_ROWS u.uid,m.mid,m.target,m.date,m.msg,m.color,m.anony,u.nickname from message m LEFT JOIN user u on m.uid=u.uid where m.uid=? order by m.mid desc limit ?,15");
            ps.setInt(1,uid);
            ps.setInt(2,pageMessageList.getIndex());
            rs = ps.executeQuery();
            while (rs.next()) {
                messageList.add(new MessageInfo(
                        rs.getInt("mid"),
                        rs.getInt("uid"),
                        rs.getString("nickname"),
                        rs.getString("target"),
                        rs.getString("date"),
                        rs.getString("msg"),
                        rs.getInt("color"),
                        rs.getInt("anony")
                ));
            }

            //获取总条数，此函数FOUND_ROWS()可以查询到上条语句如果不使用limit所返回的条数
            ps = conn.prepareStatement("select FOUND_ROWS() count");
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            // System.out.println("count = "+count);

            pageMessageList.setAllRowCount(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
        }

        return pageMessageList;

    }
}
