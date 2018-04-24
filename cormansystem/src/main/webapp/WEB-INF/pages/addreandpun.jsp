<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>标题</title>
</head>
<body>
<form method="post" action="adaddreandpun.do">
    奖惩金额：<input name="money">
    理由：<input name="explanation">
    奖惩对象：<input name="ename">
    所在职位：<input name="postition">
    奖励：<input type="radio" name="name" value="1">
    处罚：<input type="radio" name="name" value="0">
    <input type="submit" value="提交">
</form>
</body>
</html>