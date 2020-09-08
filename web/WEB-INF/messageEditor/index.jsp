<%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/8
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>添加留言</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/messageEditor/style.css"/>
</head>
<body>
<div class="nav">
    <a href="#">芒果小洛</a>
</div>
<div class="alert">
    留下您最想对他(她)说的话。他(她)可能是您曾经的朋友、曾经的恋人，或是您现在的朋友、恋人...
</div>


<form class="panel panel-style-1" action="<%=request.getContextPath()%>/addMessage" method="post">
    <div class="panel-heading panel-heading-style-1">
        <span>收信人<input type="text" name="target" id="target" /></span>
        <input type="button" value="提交" />
    </div>
    <div class="panel-body">
        <textarea id="msgTextarea"></textarea>
        <input type="text" name="msg" id="msg" />
    </div>
    <div class="panel-foot">
			<span class="panel-foot-info">
				<span>匿名发布</span>
				<input type="checkbox" name="anony" value="anony" />
				<span class="color">
					<span>主题</span>
					<input type="radio" name="color" value="1" checked="checked" />
					<input type="radio" name="color" value="2"/>
					<input type="radio" name="color" value="3"/>
					<input type="radio" name="color" value="4"/>
					<input type="radio" name="color" value="5"/>
				</span>
				<span>2020-08-01</span>
				<span class="nickname">芒果小洛</span>
			</span>
    </div>
</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/pub/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/view/messageEditor/index.js"></script>
</html>
