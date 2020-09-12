<%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/11
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/chpwd.css"/>
    <%
        UserInfo myInfo = (UserInfo)request.getAttribute("myInfo");
        // char[] chars = myInfo.getHide().toCharArray();
    %>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>



<div class="main">
    <%@include file="/WEB-INF/myInfo/pub_avatar.jsp"%>
    <div class="userinfo">
        <%@include file="/WEB-INF/myInfo/pub_nav.jsp"%>

        <form class="chpwd form" action="/chpwd" method="post">
            <span class="tip">原密码</span>
            <span class="error_tip"></span><br />
            <input type="password"/><br />

            <span class="tip">新密码</span>
            <span class="error_tip"></span><br />
            <input type="password" /><br />

            <span class="tip">确认新密码</span>
            <span class="error_tip"></span><br />
            <input type="password" /><br />

            <span class="info_tip">密码的长度在[6,20]之间，包括大小写字母、数字、下划线至少两种</span>
            <div><input type="button" value="更新" /></div>
            <span id="msg"></span>

        </form>







    </div>
</div>
</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/pub/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/pub/utils.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/view/myInfo/chpwd.js"></script>
</html>