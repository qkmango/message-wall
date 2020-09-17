package entity;

/**
 * @version 1.0
 * <p>用户登陆与注册信息 实体类</p>
 * <p>用户登陆和注册时email和password的信息封装在此类当中</p>
 * @className UserLRInfo
 * @author: Mango
 * @date: 2020-09-05 22:48
 */
public class UserLRInfo {
    private String email;
    private String password;
    private String nickname;

    public UserLRInfo(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public UserLRInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public UserLRInfo() {
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
}
