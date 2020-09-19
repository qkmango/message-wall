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
    private int mid = 1;
    //此条留言的作者uid
    private int uid = 1;
    //留言者 nickname昵称
    private String nickname = "default";
    //接受者
    private String target = "default";
    //留言时间
    private String date = "0520-13-14";
    //留言内容
    private String msg = "default";
    //留言板样式颜色
    private int color = 1;
    // 留言者是否匿名
    private int anony = 0;


    /**
     * 全参数的构造方法，  供从数据库中查找出来后封装信息
     * @param mid 此条留言的mid
     * @param uid 此留言的作者uid
     * @param nickname 留言作者的昵称
     * @param target 留言对象，收信对象
     * @param date 留言日期
     * @param msg 留言内容
     * @param color 主题颜色
     * @param anony 是否匿名
     */
    public MessageInfo(int mid, int uid, String nickname, String target, String date, String msg, int color, int anony) {
        this.mid = mid;
        this.uid = uid;
        this.nickname = nickname;
        this.target = target;
        this.date = date;
        this.msg = msg;
        this.color = color;
        this.anony = anony;
    }

    /**
     * 部分参数构造方法，供从前端获取表单后封装信息，供添加到数据库中使用
     * @param uid
     * @param target
     * @param date
     * @param msg
     * @param color
     * @param anony
     */
    public MessageInfo(int uid, String target, String date, String msg, int color, int anony) {
        this.uid = uid;
        this.target = target;
        this.date = date;
        this.msg = msg;
        this.color = color;
        this.anony = anony;
    }


    /**
     * 部分参数的构造方法，供在查看其他用户的详细信息页面时查看message时所使用
     * <p>查看其他用户的MessageList时，部分信息不需要，所以使用部分参数的构造方法</p>
     * @param mid
     * @param target
     * @param date
     * @param msg 参数说明
     * @return
     */
    public MessageInfo(int mid, String target, String date, String msg) {
        this.mid = mid;
        this.target = target;
        this.date = date;
        this.msg = msg;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getAnony() {
        return anony;
    }

    public void setAnony(int anony) {
        this.anony = anony;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", target='" + target + '\'' +
                ", date='" + date + '\'' +
                ", msg='" + msg + '\'' +
                ", color=" + color +
                ", anony=" + anony +
                '}';
    }
}
