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

</head>
<body>
<%@include file="/pub/head/head.jsp"%>

<%
    UserInfo myInfo = (UserInfo)request.getAttribute("myInfo");
    // char[] chars = myInfo.getHide().toCharArray();
%>

<div class="main">
    <div class="left">
        <%--        <img src="./img/头像.jpg"/>--%>
        <div class="nickname"><%=myInfo.getNickname()%></div>
    </div>
    <div class="userinfo">
        <div class="nav">
            <span><a href="<%=request.getContextPath()%>/myinfo?info=base">基本信息</a></span>
            <span><a href="">我的留言</a></span>
            <span><a href="">更换头像</a></span>
            <span><a href="<%=request.getContextPath()%>/myinfo?info=chpwd">更改密码</a></span>
        </div>


        <form class="chpwd form" action="/" method="post">
            <span class="tip">原密码</span>
            <span class="error_tip"></span><br />
            <input type="password"/><br />

            <span class="tip">新密码</span>
            <span class="error_tip"></span><br />
            <input type="password" /><br />

            <span class="tip">确认新密码</span>
            <span class="error_tip"></span><br />
            <input type="password" /><br />

            <span class="info_tip">确保电子邮件是合法的，并且密码的长度不小于6并且不大于20个字符，包括大写字母、小写字母、数字、下划线至少两种</span>
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