package entity;

/**
 * @version 1.0
 * <p>用户登陆与注册信息实体类</p>
 * <p>用户登陆和注册时email和password的信息封装在此类当中</p>
 * @className UserLRInfo
 * @author: Mango
 * @date: 2020-09-05 22:48
 */
public class UserLRInfo {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLRInfo() {
    }

    public UserLRInfo(String email, String password) {
        this.email = email;
        this.password = password;
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
}
