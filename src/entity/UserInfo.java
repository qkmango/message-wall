package entity;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className UserInfo
 * @author: Mango
 * @date: 2020-09-08 10:50
 */
public class UserInfo {
    private int uid;
    private String email;
    private String password;
    private String nickname;
    private int sex;
    //注册日期
    private String regdate;
    //生日
    private String birthday;
    //头像 base64字符串形式
    private String avatar;
    //QQ号
    private String qq;
    //电话
    private String tel;
    //信息隐藏项目 字符串表示，如10111，0表示自己的某个信息对外不可见
    private String hide;


    /**
     * 全参构造方法
     * @param uid
     * @param email
     * @param password
     * @param nickname
     * @param sex
     * @param regdate
     * @param birthday
     * @param avatar
     * @param qq
     * @param tel
     * @param hide
     */
    public UserInfo(int uid, String email, String password, String nickname, int sex, String regdate, String birthday, String avatar, String qq, String tel, String hide) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.regdate = regdate;
        this.birthday = birthday;
        this.avatar = avatar;
        this.qq = qq;
        this.tel = tel;
        this.hide = hide;
    }

    /**
     * 除password的构造方法，供用户信息详情页使用
     * @param uid
     * @param email
     * @param nickname
     * @param sex
     * @param regdate
     * @param birthday
     * @param avatar
     * @param qq
     * @param tel
     * @param hide
     */
    public UserInfo(int uid, String email, String nickname, int sex, String regdate, String birthday, String avatar, String qq, String tel, String hide) {
        this.uid = uid;
        this.email = email;
        this.nickname = nickname;
        this.sex = sex;
        this.regdate = regdate;
        this.birthday = birthday;
        this.avatar = avatar;
        this.qq = qq;
        this.tel = tel;
        //需要对外隐藏或显示的个人信息，使用字符串来表示出来
        this.hide = hide;
    }

    /**
     * 部分参数的构造方法，供用户更新信息后后台将新的用户信息封装为UserInfo对象，传入模型层对数据库进行操作
     * @param uid
     * @param nickname
     * @param sex
     * @param birthday
     * @param qq
     * @param tel
     * @param hide
     */
    public UserInfo(int uid, String nickname, int sex, String birthday, String qq, String tel, String hide) {
        this.uid = uid;
        this.nickname = nickname;
        this.sex = sex;
        this.birthday = birthday;
        this.qq = qq;
        this.tel = tel;
        //需要对外隐藏或显示的个人信息，使用字符串来表示出来
        this.hide = hide;
    }



    /**
     * 部分参数的构造方法，供登陆后的非用户详情页的最基本信息使用
     * @param uid
     * @param nickname
     * @param sex
     */
    public UserInfo(int uid, String nickname, int sex) {
        this.uid = uid;
        this.nickname = nickname;
        this.sex = sex;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", regdate='" + regdate + '\'' +
                ", birthday='" + birthday + '\'' +
                ", avatar='" + avatar + '\'' +
                ", qq='" + qq + '\'' +
                ", tel='" + tel + '\'' +
                ", hide='" + hide + '\'' +
                '}';
    }
}
