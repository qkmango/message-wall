<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="nav">
    <span><a href="<%=request.getContextPath()%>/userinfo?uid=<%=uid%>&info=base">基本信息</a></span>
    <span><a href="<%=request.getContextPath()%>/userinfo?uid=<%=uid%>&info=messagelist">TA的留言</a></span>
</div>

