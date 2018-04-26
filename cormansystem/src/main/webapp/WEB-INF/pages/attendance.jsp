<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/26
  Time: 11:14
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
<a href="statetime.do">上班打卡</a>
<a href="offtime.do">下班打卡</a>
<a href="saveattendance.do">查看打卡记录</a>
</body>
</html>