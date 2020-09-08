package entity;

/**
 * @version 1.0
 * <p>留言的详情类</p>
 * <p>此类封装了留言的相关信息</p>
 * @className Message
 * @author: Mango
 * @date: 2020-09-08 01:09
 */
public class MessageInfo {
    //id
    private int mid;
    //留言者 nickname昵称
    private String nickname;
    //接受者
    private String target;
    //留言时间
    private String date;
    //留言内容
    private String msg;
    //留言板样式颜色
    private int color;
    // 留言者是否匿名
    private boolean anony;

    public MessageInfo(int mid, String nickname, String target, String date, String msg, int color, boolean anony) {
        this.mid = mid;
        this.nickname = nickname;
        this.target = target;
        this.date = date;
        this.msg = msg;
        this.color = color;
        this.anony = anony;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isAnony() {
        return anony;
    }

    public void setAnony(boolean anony) {
        this.anony = anony;
    }
}
