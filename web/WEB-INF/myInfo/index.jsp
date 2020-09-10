<%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/10
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/style.css"/>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>


<div class="main">
    <div class="left">
<%--        <img src="./img/头像.jpg"/>--%>
        <div class="nickname">芒果小洛</div>
    </div>
    <div class="userinfo">
        <div class="nav">
            <span>基本信息</span>
            <span>我的留言</span>
            <span>更换头像</span>
            <span>更改密码</span>
        </div>
        <form class="basicinfo" action="/" method="post">
            <div>
                <span>信息</span>
                <span>值</span>
                <span>对外隐藏</span>
            </div>
            <div>
                <span>昵称</span>
                <span><input type="text" name="nickname" value="芒果小洛" /></span>
            </div>
            <div>
                <span>UID</span>
                <span>00001</span>
            </div>
            <div>
                <span>注册邮箱</span>
                <span>2099432021@qq.com</span>
                <span><input type="checkbox" /></span>
            </div>
            <div>
                <span>性别</span>
                <span>
						<span>男</span><input type="radio" name="sex" value="1" checked="checked" />
						<span>女</span><input type="radio" name="sex" value="0" />
					</span>
                <span><input type="checkbox" /></span>
            </div>
            <div>
                <span>注册日期</span>
                <span>2020-08-09</span>
            </div>
            <div>
                <span>生日</span>
                <span><input type="date" name="birthday" value="2000-11-13" id="birthday" /></span>
                <span><input type="checkbox" /></span>
            </div>
            <div>
                <span>QQ</span>
                <span><input type="text" name="qq" value="2099432021" maxlength="11" /></span>
                <span><input type="checkbox" /></span>
            </div>
            <div>
                <span>电话</span>
                <span><input type="text" name="tel" value="15178140229" maxlength="11" /></span>
                <span><input type="checkbox" /></span>
            </div>
            <div><input type="button" value="更新"/></div>
            <span id="msg"></span>
        </form>
    </div>
</div>

</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/pub/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/view/myInfo/index.js"></script>
</html>
