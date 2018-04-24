<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 20:23
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
<a href="adminsaveresume.do">查看接收的简历</a>
<a href="savedepartment.do">查看各部门信息</a>
<a href="adsavetrain.do">安排培训事宜</a>
<a href="adsavereandpun.do">管理员工奖惩信息</a>
</body>
</html>