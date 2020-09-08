<%@ page import="entity.MessageInfo" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="entity.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/8
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>留言墙</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/messagewall/style.css"/>
</head>
<body>
<div class="nav">


    <%
        HttpSession session = request.getSession(false);
        if (session != null) {
            UserInfo user = (UserInfo)session.getAttribute("user");
            out.write("<a href='#'>"+user.getNickname()+"</a>");
            // out.write(user.toString());
            // out.write("芒果小洛");
        } else {
            out.write("<a href='/MessageWall/view/login/'>登陆</a>");
        }
    %>

</div>
<div class="alert">
    留言墙，又称心灵驿站、心情墙，留下你此时此刻的心情。<br />
    也可留下您曾经对他(她)最想说的话，他(她)可能是您曾经的朋友、曾经的恋人，亦可是当下的朋友、恋人，或者你自己，更或者是暗恋对象<br />
    您可以实名留言、也可以匿名留言。场景可用于毕业留言、心情留言、生活随笔、贺卡、记录您生活的点点滴滴<br />
</div>
<div class="main">
    <div class="center">
        <div class="search clearfix">
            <form action="" method="get">
                <input type="text" />
                <input type="submit" value="搜索" />
            </form>
        </div>


<%--        JSP--%>
        <% LinkedList<MessageInfo> messageList = (LinkedList<MessageInfo>)request.getAttribute("messageList");%>
        <% int len = messageList.size(); %>
        <%for (int i = 0; i < len; i++) { %>
        <% MessageInfo messageInfo = messageList.get(i); %>

        <div class="list">
            <div class="panel">
                <div class="panel-heading">
                    <span><%=messageInfo.getTarget()%></span>
                </div>
                <div class="panel-body"><%=messageInfo.getMsg()%></div>
                <div class="panel-foot">
                    <a href="check?mid=<%=messageInfo.getMid()%>"><button>查看</button></a>
                    <span class="panel-foot-info">
                        <span><%=messageInfo.getDate()%></span>
                        <span><%=messageInfo.getNickname()%></span>
                    </span>
                </div>
            </div>
        </div>

        <%}%>
<%--       JSP end--%>

    </div>
    <div class="tab">
        <a href="#"><div class="add">立即留言</div></a>
    </div>
</div>
</body>
</html>
