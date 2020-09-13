<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html lang="zh-CN">
<head>
    <title>更换头像</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pub/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/myInfo/chavatar.css"/>
    <%
        UserInfo myInfo = (UserInfo)request.getAttribute("myInfo");
        // char[] chars = myInfo.getHide().toCharArray();
    %>
</head>
<body>
<%@include file="/pub/head/head.jsp"%>

<div class="main">
    <%@include file="/WEB-INF/myInfo/pub_avatar.jsp"%>

    <div class="userinfo">

        <%@include file="/WEB-INF/myInfo/pub_nav.jsp"%>

        <form class="chavatar form" action="/chavatar" method="post">


            <div>
                <span id="-1">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test"></use>
                    </svg>
                </span>
                <span id="-2">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test2"></use>
                    </svg>
                </span>
                <span id="-3">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test3"></use>
                    </svg>
                </span>
                <span id="-4">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test8"></use>
                    </svg>
                </span>
                <span id="-5">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test14"></use>
                    </svg>
                </span>
                <span id="-6">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test15"></use>
                    </svg>
                </span>
                <span id="-7">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test17"></use>
                    </svg>
                </span>
                <span id="-8">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-icon-test-copy"></use>
                    </svg>
                </span>
                <span id="0">
                    <img  id="img" />
                </span>
                <span>
                    <input type="file" id="img_upload" />
                </span>
            </div>
            <div class="radio">
                <input type="radio" name="avatar" value="#icon-icon-test"/>
                <input type="radio" name="avatar" value="#icon-icon-test2"/>
                <input type="radio" name="avatar" value="#icon-icon-test3"/>
                <input type="radio" name="avatar" value="#icon-icon-test8"/>
                <input type="radio" name="avatar" value="#icon-icon-test14"/>
                <input type="radio" name="avatar" value="#icon-icon-test15"/>
                <input type="radio" name="avatar" value="#icon-icon-test17"/>
                <input type="radio" name="avatar" value="#icon-icon-test-copy"/>
                <input type="radio" name="avatar" value="0"/>
            </div>






            <div>
                <input type="button" value="更新" />
                <input type="reset" value="取消" />
            </div>


            <span id="msg"></span>
        </form>


    </div>
</div>


</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/pub/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/view/myInfo/chavatar.js"></script>
<script src="<%=request.getContextPath()%>/pub/iconfont/iconfont.js"></script>
</html>
