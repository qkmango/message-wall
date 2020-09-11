package Utils;

import entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className GetUserInfoFromUid
 * @author: Mango
 * @date: 2020-09-10 12:36
 */
public class UserInfoUtils {

    public static UserInfo getUserInfoFromUid(int uid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserInfo userInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(true);

            ps = conn.prepareStatement("select uid,email,nickname,sex,regdate,birthday,avatar,qq,tel,hide from user where uid=?");
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

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return userInfo;
        }
    }
}
