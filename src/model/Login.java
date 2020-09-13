package model;

import Utils.JDBCUtils;
import entity.UserInfo;
import entity.UserLRInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description:
 * <p>登陆类</p>
 * <p>判断用户是否可登陆的类，提供了canLogin()静态静态方法判断是否可登陆</p>
 * @className LoginServlet
 * @author: Mango
 * @date: 2020-09-05 22:39
 */
public class Login {

    /**
     * 判断用户是否可登陆
     * <p>查询数据库判断用户是否可登陆</p>
     * @param userLRInfo 用户登陆信息类
     * @return 如果email和password匹配则返回用户详细信息封装类UserInfo，否则返回null；
     */
    public static UserInfo canLogin(UserLRInfo userLRInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //查询数据
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);
            ps = conn.prepareStatement("select uid,nickname,sex from user where email=? && password=?");
            ps.setString(1, userLRInfo.getEmail());
            ps.setString(2, userLRInfo.getPassword());
            rs = ps.executeQuery();
            //如果查询结果集中有一行数据说明email和password匹配，是否可登陆的表级改为true
            if (rs.next()) {
                int uid = rs.getInt("uid");
                // String email = rs.getString("email");
                // String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int sex = rs.getInt("sex");

                UserInfo user = new UserInfo(uid,nickname,sex);

                System.out.println(user.toString());
                return user;
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            //关闭资源
            JDBCUtils.closeAll(conn,ps,rs);
        }

    }


    /**
     * 信息更新后，重新查询数据库
     * <p>信息更新后重新查新数据库，返回一个新的UserInfo user对象</p>
     * @param uid 参数说明
     * @return UserInfo用户登陆后非个人信息页的所需要的基本信息 uid,nickname,sex
     */
    public static UserInfo ReloadUserInfo(int uid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //查询数据
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);
            ps = conn.prepareStatement("select uid,nickname,sex from user where uid=?");
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            //如果查询结果集中有一行数据说明email和password匹配，是否可登陆的表级改为true
            if (rs.next()) {
                // int uid = rs.getInt("uid");
                // String email = rs.getString("email");
                // String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                int sex = rs.getInt("sex");

                UserInfo user = new UserInfo(uid,nickname,sex);

                // System.out.println(user.toString());
                return user;
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            //关闭资源
            JDBCUtils.closeAll(conn,ps,rs);
        }

    }

}
