package Utils;

import entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * <p>获取用户信息</p>
 * <p>类详细介绍</p>
 * @className GetUserInfoFromUid
 * @author: Mango
 * @date: 2020-09-10 12:36
 */
public class UserInfoUtils {

    /**
     * 通过用户的uid来获取用户的所有信息（除密码）
     * @param uid 用户的uid
     * @return entity.UserInfo 用户信息对象
     */
    public static UserInfo getUserInfoFromUid(int uid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserInfo userInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);

            //当头像为null时，将其值设置为默认的头像的代号
            ps = conn.prepareStatement("select uid,email,nickname,sex,regdate,birthday,ifnull(avatar,'#icon-icon-test') avatar,qq,tel,hide from user where uid=?");
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                userInfo = new UserInfo(
                        rs.getInt("uid"),
                        rs.getString("email"),
                        rs.getString("nickname"),
                        rs.getInt("sex"),
                        rs.getString("regdate"),
                        rs.getString("birthday"),
                        rs.getString("avatar"),
                        rs.getString("qq"),
                        rs.getString("tel"),
                        rs.getString("hide")
                );
            }

            System.out.println(rs.getString("avatar").length());
            System.out.println(rs.getString("avatar"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn,ps,rs);
            return userInfo;
        }
    }
}
