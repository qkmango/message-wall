package entity;

import java.util.LinkedList;

/**
 * @version 1.0
 * <p>message分页</p>
 * <p>一个此类表示一个分页中所有的message，以及分页的一些信息</p>
 * @className PageMessageList
 * @author: Mango
 * @date: 2020-09-16 17:04
 */
public class PageMessageList {
    private int pageNum = 1;            //查询的页数(第几页)
    private int index = 0;              //查询的第一条下标（供SQL语句使用）
    private int pageSize = 8;    //查询的每页条数
    private int allRowCount;            //数据库中总条数
    private LinkedList<MessageInfo> messageList = new LinkedList<>();

    public PageMessageList(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    //
    // public PageMessageList(int pageNum) {
    //     this.pageNum = pageNum;
    // }

    public int getPageNum() {
        if (pageNum<=0) {
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public LinkedList<MessageInfo> getMessageList() {
        return messageList;
    }

    public void setMessageList(LinkedList<MessageInfo> messageList) {
        this.messageList = messageList;
    }

    public int getAllRowCount() {
        return allRowCount;
    }

    public void setAllRowCount(int allCount) {
        this.allRowCount = allCount;
    }

    public int getIndex() {
        index = (getPageNum() - 1) * pageSize;
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getBackPageNum() {
        return getPageNum() - 1>0?getPageNum() - 1:1;
    }

    public int getNextPageNum() {
        int allPageCount = getAllPageCount();
        int nextPageNum = getPageNum() + 1 < allPageCount ? getPageNum() + 1 : allPageCount;
        return nextPageNum;
    }
    
    /**
     * 获取所有的页数
     * @return 返回总页数
     */
    public int getAllPageCount() {
        //注意：Math.ceil(double)需要一个double的数据，如果传入的是一个int类型，则会出错，会有向下取整的效果
        double allPageCount = Math.ceil((double) allRowCount / pageSize);
        return (int) allPageCount;
    }

}
