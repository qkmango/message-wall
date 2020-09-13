<%@ page import="entity.UserInfo" %>
<%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/9
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>

<%--页面公共的头部--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/head/style.css"/>
<body>
    <div class="header-nav">
        <a href="/MessageWall/messagewall">主页</a>
        <%--JSP--%>
        <%
            HttpSession session = request.getSession(false);
            if (session != null) {
                UserInfo user = (UserInfo)session.getAttribute("user");
                out.write("<a href="+request.getContextPath()+"/logout"+">退出</a><a href='myinfo?info=base'>"+user.getNickname()+"</a>");
            } else {
                out.write("<a href='/MessageWall/view/login/'>登陆</a>");
            }
        %>
        <%--JSP end--%>

    </div>
</body>
</html>
