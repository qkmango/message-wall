<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="zh-CN">
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/user/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/user/base.css"/>
    <%
        UserInfo userInfo = (UserInfo)request.getAttribute("userInfo");
        //(其他用户的uid，查看此用户的详细信息页面使用)
        int uid = Integer.parseInt(request.getParameter("uid"));
    %>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>



<div class="main">
    <%@include file="/WEB-INF/userInfo/pub_avatar.jsp"%>

    <%@include file="/WEB-INF/userInfo/pub_nav.jsp"%>
    <div class="userinfo">

        <form class="basicinfo" >
            <div>
                <span>信息</span>
                <span>值</span>
            </div>
            <div>
                <span>昵称</span>
                <span><%=userInfo.getNickname()%></span>
            </div>
            <div>
                <span>UID</span>
                <span><%=userInfo.getUid()%></span>
            </div>
            <div>
                <span>注册邮箱</span>
                <span><%=userInfo.getEmail()=="-1"?"隐藏":userInfo.getEmail()%></span>
            </div>
            <div>
                <span>性别</span>
<%--                先判断此信息是否为隐藏信息，隐藏信息在后台已被过滤，值为-1或"-1"
                    如果不是隐藏信息，在判断是男还是女--%>
                <span><%=userInfo.getSex()==-1?"隐藏":(userInfo.getSex()==0?"女":"男")%></span>
            </div>
            <div>
                <span>注册日期</span>
                <span><%=userInfo.getRegdate()%></span>
            </div>
            <div>
                <span>生日</span>
                <span><%=userInfo.getBirthday()=="-1"?"隐藏":userInfo.getBirthday()%></span>
            </div>
            <div>
                <span>QQ</span>
<%--                先判断是否被用户隐藏此条信息，然后再判断是否为空""，如果为空字符串，会影响前端布局，所以如果为空的话设置为显示为"空"--%>
                <span><%=userInfo.getQq()=="-1"?"隐藏":(userInfo.getQq()==""?"空":userInfo.getQq())%></span>
            </div>
            <div>
                <span>电话</span>
<%--                先判断是否被用户隐藏此条信息，然后再判断是否为空""，如果为空字符串，会影响前端布局，所以如果为空的话设置为显示为"空"--%>
                <span><%=userInfo.getTel()=="-1"?"隐藏":(userInfo.getTel()==""?"空":userInfo.getTel())%></span>
            </div>
        </form>
    </div>
</div>


<%@include file="/pub/footer/index.jsp"%>
</body>

</html>
