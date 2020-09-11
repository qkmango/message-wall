package model;

import Utils.UserInfoUtils;
import entity.UserInfo;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className MyInfo
 * @author: Mango
 * @date: 2020-09-10 12:26
 */
public class MyInfo {

    public static UserInfo getMyInfo(int uid) {

        UserInfo userInfo = UserInfoUtils.getUserInfoFromUid(uid);
        return userInfo;
    }
}
