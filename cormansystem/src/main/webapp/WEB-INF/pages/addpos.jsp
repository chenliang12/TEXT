<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 15:03
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
<form action="addpostitions.do" method="post">
    <input name="p_position">
    <input hidden>
    <input type="submit" value="创建职位">
</form>
</body>
</html>