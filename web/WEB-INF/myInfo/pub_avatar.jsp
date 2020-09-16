<%--
  Created by IntelliJ IDEA.
  User: Mango
  Date: 2020/9/12
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<div class="left">
    <%
        String avatar = myInfo.getAvatar();
        if (avatar.length() > 25) {
            out.write("<img id='avatar' src="+avatar+" />");
        } else {
            out.write("<svg class='icon' id='avatar' aria-hidden='true'>" +
                    "<use xlink:href='"+avatar+"'></use>'" +
                    "</svg>");
        }
    %>


    <div class="nickname"><%=myInfo.getNickname()%></div>
</div>
<script src="<%=request.getContextPath()%>/pub/iconfont/iconfont.js"></script>

