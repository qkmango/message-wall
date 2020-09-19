package Utils;

import entity.UserInfo;

/**
 * @version 1.0
 * <p>用户信息过滤隐藏项</p>
 * <p>隐藏项过滤后值为String "-1"或 int -1</p>
 * @className UserInfoHideFilter
 * @author: Mango
 * @date: 2020-09-19 18:26
 */
public class UserInfoHideFilter {
    public static UserInfo toFilter(UserInfo userinfo) {
        char[] chars = userinfo.getHide().toCharArray();
        if (chars[0]=='0') { userinfo.setEmail("-1"); }
        if (chars[1]=='0') { userinfo.setSex(-1); }
        if (chars[2]=='0') { userinfo.setBirthday("-1"); }
        if (chars[3]=='0') { userinfo.setQq("-1"); }
        if (chars[4]=='0') { userinfo.setTel("-1"); }

        return userinfo;
    }
}
