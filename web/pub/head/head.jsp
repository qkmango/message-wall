<%@ page import="entity.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/head/index.css"/>
<body>

<%
    HttpSession session = request.getSession(false);
%>

    <nav>
        <img src="<%=request.getContextPath()%>/pub/imgs/head/logo_title.png" id="logo" />
        <a href="/MessageWall/messagewall" id="index">
            <img src="<%=request.getContextPath()%>/pub/imgs/head/index.svg" id="index_img" />
            <span id="index_link">主页</span>
        </a>

        <a href="<%=session==null?"/MessageWall/view/login/":request.getContextPath()+"/logout"%>" id="login_logout">
            <img src="<%=request.getContextPath()%>/pub/imgs/title_icon/log-<%=session==null?"in":"out"%>.svg" />
            <span><%=session==null?"登陆":"退出"%></span>
        </a>

        <%
            if (session!=null) {
                UserInfo user = (UserInfo)session.getAttribute("user");
                String nickname = user.getNickname();
                String contextPath = request.getContextPath();
                out.write("<a href=myinfo?info=base id=my target='_blank'>");
                out.write("");
                out.write("<img src="+contextPath+"/pub/imgs/head/user.svg />");
                out.write("<span>"+nickname+"</span>");
            }
        %>

        </a>
    </nav>
    <div id="solvefix"></div>
</div>
</body>
</html>
