<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/base.css"/>
    <%
        UserInfo myInfo = (UserInfo)request.getAttribute("myInfo");
        char[] chars = myInfo.getHide().toCharArray();
    %>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>



<div class="main">
    <%@include file="/WEB-INF/myInfo/pub_avatar.jsp"%>

    <div class="userinfo">

        <%@include file="/WEB-INF/myInfo/pub_nav.jsp"%>
        <form class="basicinfo" action="/updatemyinfo" method="post">
            <div>
                <span>信息</span>
                <span>值</span>
                <span>对外隐藏</span>
            </div>
            <div>
                <span>昵称</span>
                <span><input type="text" name="nickname" value="<%=myInfo.getNickname()%>" /></span>
            </div>
            <div>
                <span>UID</span>
                <span><%=myInfo.getUid()%></span>
            </div>
            <div>
                <span>注册邮箱</span>
                <span><%=myInfo.getEmail()%></span>
                <span><input type="checkbox" <%=(chars[0] == '0')?"checked='checked'":""%> /></span>
            </div>
            <div>
                <span>性别</span>
                <span>
                            <select name="sex">
                                <option value="1" <%=(myInfo.getSex() == 1)?"selected='selected'":""%>>男</option>
                                <option value="0" <%=(myInfo.getSex() == 0)?"selected='selected'":""%>>女</option>
                            </select>
                        </span>
                <span><input type="checkbox" <%=(chars[1] == '0')?"checked='checked'":""%>/></span>
            </div>
            <div>
                <span>注册日期</span>
                <span><%=myInfo.getRegdate()%></span>
            </div>
            <div>
                <span>生日</span>
                <span><input type="date" name="birthday" value="<%=myInfo.getBirthday()%>" id="birthday" /></span>
                <span><input type="checkbox" <%=(chars[2] == '0')?"checked='checked'":""%>/></span>
            </div>
            <div>
                <span>QQ</span>
                <span><input type="text" name="qq" value="<%=myInfo.getQq()%>" maxlength="11" /></span>
                <span><input type="checkbox" <%=(chars[3] == '0')?"checked='checked'":""%>/></span>
            </div>
            <div>
                <span>电话</span>
                <span><input type="text" name="tel" value="<%=myInfo.getTel()%>" maxlength="11" /></span>
                <span><input type="checkbox" <%=(chars[4] == '0')?"checked='checked'":""%>/></span>
            </div>
            <div>
                <input type="button" value="更新"/>
            </div>
            <span id="msg"></span>
        </form>
    </div>
</div>
</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/pub/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/pub/utils.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/view/myInfo/base.js"></script>

</html>
