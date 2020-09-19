<%@ page import="entity.PageMessageList" %>
<%@ page import="entity.MessageInfo" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="zh-CN">
<head>
    <title>TA的留言</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/user/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/user/messagelist.css"/>
    <%
        int uid = Integer.parseInt(request.getParameter("uid"));
        UserInfo userInfo = (UserInfo)request.getAttribute("userInfo");
        PageMessageList pageMessageList = (PageMessageList)request.getAttribute("pageMessageList");
        LinkedList<MessageInfo> messageList = pageMessageList.getMessageList();
    %>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>

<div class="main">
    <%@include file="/WEB-INF/userInfo/pub_avatar.jsp"%>
    <%@include file="/WEB-INF/userInfo/pub_nav.jsp"%>
    <div class="userinfo">
        <form class="message_list">
            <table valign="top">
                <tr>
                    <th>MID</th>
                    <th>对象</th>
                    <th>日期</th>
                    <th id="msg_title">内容</th>
                    <th>详情</th>
                </tr>

                <%
                    for (int i = 0; i<messageList.size(); i++) {
                        MessageInfo messageInfo = messageList.get(i);
                        out.write("<tr>");
                        out.write("<td>"+messageInfo.getMid()+"</td>");
                        out.write("<td>"+messageInfo.getTarget()+"</td>");
                        out.write("<td>"+messageInfo.getDate()+"</td>");
                        out.write("<td>"+messageInfo.getMsg()+"</td>");
                        out.write("<td><a href=detmessage?mid="+messageInfo.getMid()+">详情</a></td>");
                        out.write("</tr>");
                    }
                %>
            </table>



            <div class="indexes">
                <a href="userinfo?uid=<%=uid%>&info=messagelist&page=<%=pageMessageList.getBackPageNum()%>" id="back">上一页</a>
                <a href="userinfo?uid=<%=uid%>&info=messagelist&page=<%=pageMessageList.getNextPageNum()%>" id="next">下一页</a>
                <div class="index_info">
                    <span>当前页:<%=pageMessageList.getPageNum()%></span>
                    <span>总页数:<%=pageMessageList.getAllPageCount()%></span>
                    <span>总条数:<%=pageMessageList.getAllRowCount()%></span>
                </div>
                <ul class="indexes_ul">
                    <%
                        int pageNum = pageMessageList.getPageNum();
                        int allPageCount = pageMessageList.getAllPageCount();
                        //printStartPageNum 打印的右侧索引开始页面数字，默认是当前页面的的前20页，最低为第一页
                        //printEndPageNum 打印的右侧索引结束页面数字，默认是当前页面的的后20页，最高为总页数
                        int printStartPageNum = pageNum-20 > 0 ? pageNum- 20 : 1;
                        int printEndPageNum = pageNum+20 < allPageCount ? pageNum+20 : allPageCount;

                        for (int i = printStartPageNum; i<=printEndPageNum; i++) {
                            out.write("<a href='userinfo?uid="+uid+"&info=messagelist&page="+i+"'");
                            if(pageNum==i) out.write(" id='this_page_index' ");
                            out.write(">"+i+"</a>");
                        }
                    %>
                </ul>
            </div>
        </form>
    </div>
</div>


<%--页脚--%>
<%@include file="/pub/footer/index.jsp"%>
</body>

</html>
