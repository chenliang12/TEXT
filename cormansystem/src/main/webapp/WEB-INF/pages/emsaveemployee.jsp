<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 10:00
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
<table border="1">
    <tr>
        <td>姓名</td>
        <td>${sessionScope.employee.e_name}</td>
    </tr>
    <tr>
        <td>年龄</td>
        <td>${sessionScope.employee.e_age}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td>${sessionScope.employee.e_sex}</td>
    </tr>
    <tr>
        <td>手机号码</td>
        <td>${sessionScope.employee.e_phone}</td>
    </tr>
    <tr>
        <td>状态</td>
        <td>${sessionScope.employee.e_state}</td>
    </tr>
</table>
</body>
</html>