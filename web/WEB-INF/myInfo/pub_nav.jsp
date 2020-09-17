<%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/12
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="nav">
    <span><a href="<%=request.getContextPath()%>/myinfo?info=base">基本信息</a></span>
    <span><a href="<%=request.getContextPath()%>/myinfo?info=messagelist">我的留言</a></span>
    <span><a href="<%=request.getContextPath()%>/myinfo?info=chavatar">更换头像</a></span>
    <span><a href="<%=request.getContextPath()%>/myinfo?info=chpwd">更改密码</a></span>
</div>

