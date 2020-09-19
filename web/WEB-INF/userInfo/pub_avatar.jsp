<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<div class="left">
    <%
        String avatar = userInfo.getAvatar();
        if (avatar.length() > 25) {
            out.write("<img id='avatar' src="+avatar+" />");
        } else {
            out.write("<svg class='icon' id='avatar' aria-hidden='true'>" +
                    "<use xlink:href='"+avatar+"'></use>'" +
                    "</svg>");
        }
    %>


    <div class="nickname"><%=userInfo.getNickname()%></div>
</div>
<script src="<%=request.getContextPath()%>/pub/iconfont/iconfont.js"></script>

