<%@ page import="entity.MessageInfo" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entity.PageMessageList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>搜索留言</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/searchMessage/style.css"/>
<%--    搜索的内容文字--%>
    <%
        String search = (String) request.getAttribute("search");
    %>
</head>
<body>

<%--页面头部--%>
<%@include file="/pub/head/head.jsp"%>

<%--<div class="alert">--%>
<%--    留言墙，又称心灵驿站、心情墙，留下你此时此刻的心情。<br />--%>
<%--    也可留下您曾经对他(她)最想说的话，他(她)可能是您曾经的朋友、曾经的恋人，亦可是当下的朋友、恋人，或者你自己，更或者是暗恋对象<br />--%>
<%--    您可以实名留言、也可以匿名留言。场景可用于毕业留言、心情留言、生活随笔、贺卡、记录您生活的点点滴滴<br />--%>
<%--</div>--%>
<div class="main">
    <div class="center">
        <div class="search clearfix">
            <form action="search" method="get">
                <input type="text" name="search" value='<%=search%>' />
                <input type="submit" value="搜索" />
            </form>
        </div>

        <table class="list_table" valign="top">
            <tr>
                <th>MID</th>
                <th>UID</th>
                <th>作者</th>
                <th>对象</th>
                <th>时间</th>
                <th>内容</th>
                <th>详情</th>
            </tr>
        <%--        JSP--%>
        <%
            PageMessageList pageMessageList = (PageMessageList)request.getAttribute("pageMessageList");
            LinkedList<MessageInfo> messageList = pageMessageList.getMessageList();
            int len = messageList.size();
            boolean anony = false;
            for (int i = 0; i < len; i++) {
                MessageInfo messageInfo = messageList.get(i);
                anony = messageInfo.getAnony()==0;

        %>
            <tr>
                <td><%=messageInfo.getMid()%></td>
                <td><%=anony?"匿名对象":messageInfo.getUid()%></td>
                <td><%=anony?"匿名对象":messageInfo.getNickname()%></td>
                <td><%=messageInfo.getTarget()%></td>
                <td><%=messageInfo.getDate()%></td>
                <td><%=messageInfo.getMsg()%></td>
                <td><a href="detmessage?mid=<%=messageInfo.getMid()%>" target="_blank">详情</a></td>
            </tr>
        <%}%>
        </table>
        <%--       JSP end--%>

    </div>
    <div class="tab">
        <%--    右侧索引--%>
        <div class="indexes">
            <%-- http://localhost:8080/MessageWall/search?search=TEST&page=1--%>
            <a href="search?page=<%=pageMessageList.getBackPageNum()%>&search=<%=search%>" id="back">上一页</a>
            <a href="search?page=<%=pageMessageList.getNextPageNum()%>&search=<%=search%>" id="next">下一页</a>
            <a href="search?page=1&search=<%=search%>" id="first">首页</a>
            <a href="search?page=<%=pageMessageList.getAllPageCount()%>&search=<%=search%>" id="last">尾页</a>
            <div class="index_info">
                <div>当前页：<%=pageMessageList.getPageNum()%></div>
                <div>总页数：<%=pageMessageList.getAllPageCount()%></div>
                <div>总条数：<%=pageMessageList.getAllRowCount()%></div>
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
                        //http://localhost:8080/MessageWall/search?search=TEST&page=1
                        out.write("<a href='search?"+"search="+search+"&page="+i+"'");
                        if(pageNum==i) out.write(" id='this_page_index' ");
                        out.write(">"+i+"</a>");
                    }
                %>
            </ul>
        </div>

    </div>
</div>
<%@include file="/pub/footer/index.jsp"%>
</body>
</html>
