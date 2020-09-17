<%@ page import="entity.PageMessageList" %>
<%@ page import="entity.MessageInfo" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="zh-CN">
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/messagelist.css"/>
    <%
        UserInfo myInfo = (UserInfo)request.getAttribute("myInfo");
        PageMessageList pageMessageList = (PageMessageList)request.getAttribute("pageMessageList");
        LinkedList<MessageInfo> messageList = pageMessageList.getMessageList();
    %>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>



<div class="main">
    <%@include file="/WEB-INF/myInfo/pub_avatar.jsp"%>
    <%@include file="/WEB-INF/myInfo/pub_nav.jsp"%>
    <div class="userinfo">
        <form class="message_list" action="" method="post">
            <table valign="top">
                <tr>
                    <th>MID</th>
                    <th>对象</th>
                    <th>主题</th>
                    <th>是否匿名</th>
                    <th>日期</th>
                    <th id="msg_title">内容</th>
                    <th>详情</th>
                    <th>操作</th>
                </tr>

                <%
                    for (int i = 0; i<messageList.size(); i++) {
                        MessageInfo messageInfo = messageList.get(i);
                        out.write("<tr>");
                        out.write("<td>"+messageInfo.getMid()+"</td>");
                        out.write("<td>"+messageInfo.getTarget()+"</td>");
                        out.write("<td>"+messageInfo.getColor()+"</td>");
                        if (messageInfo.getAnony()==0) {
                            out.write("<td>匿名</td>");
                        } else {
                            out.write("<td></td>");
                        }
                        out.write("<td>"+messageInfo.getDate()+"</td>");
                        out.write("<td>"+messageInfo.getMsg()+"</td>");
                        out.write("<td><a href=detmessage?mid="+messageInfo.getMid()+">详情</a></td>");
                        out.write("<td><input type='checkbox' value='"+messageInfo.getMid()+"' /></td>");
                        out.write("</tr>");
                    }
                %>
            </table>



            <div class="indexes">
                <a href="myinfo?info=messagelist&page=<%=pageMessageList.getBackPageNum()%>" id="back">上一页</a>
                <a href="myinfo?info=messagelist&page=<%=pageMessageList.getNextPageNum()%>" id="next">下一页</a>
                <div class="index_info">
                    <span>当前页:<%=pageMessageList.getPageNum()%></span>
                    <span>总页数:<%=pageMessageList.getAllPageCount()%></span>
                    <span>总条数:<%=pageMessageList.getAllRowCount()%></span>
                </div>
                <ul class="indexes_ul">
                    <%
                        int pageNum = pageMessageList.getPageNum();
                        int allPageCount = pageMessageList.getAllPageCount();
                        int printStartPageNum = pageNum-10 > 0 ? pageNum- 10 : 1;
                        int printEndPageNum = pageNum+10 < allPageCount ? pageNum+10 : allPageCount;

                        for (int i = printStartPageNum; i<=printEndPageNum; i++) {
                            out.write("<a href='myinfo?info=messagelist&page="+i+"'");
                            if(pageNum==i) out.write(" id='this_page_index' ");
                            out.write(">"+i+"</a>");
                        }
                    %>
                </ul>
            </div>



            <div><input type="button" value="更新" /></div>
            <span id="msg"></span>
        </form>
    </div>
</div>


<%--页脚--%>
<%@include file="/pub/footer/index.jsp"%>
</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/pub/jquery-3.5.1.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/pub/utils.js"></script>--%>
<script type="text/javascript" src="<%=request.getContextPath()%>/view/myInfo/messagelist.js"></script>

</html>
