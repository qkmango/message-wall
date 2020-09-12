package entity;

/**
 * @version 1.0
 * <p>更改密码时使用的类，存在旧密码和新密码</p>
 * <p>类详细介绍</p>
 * @className ChangePwd
 * @author: Mango
 * @date: 2020-09-12 08:46
 */
public class ChPwdEty {
    private int uid;
    private String oldPwd;
    private String newPwd;

    public ChPwdEty(int uid, String oldPwd, String newPwd) {
        this.uid = uid;
        this.oldPwd = oldPwd;
        this.newPwd = newPwd;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
