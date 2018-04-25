<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/25
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="post" action="addrecruiment.do">
<table border="1">
    <tr>
        <td>职位</td>
        <td><input name="r_job"></td>
    </tr>
    <tr>
        <td>基本工资</td>
        <td><input name="r_wage"></td>
    </tr>
    <tr>
        <td>工作要求</td>
        <td><input name="r_demand"></td>
    </tr>
    <tr>
        <td>待遇</td>
        <td><input name="r_treatment"></td>
    </tr>
    <tr>
        <td>工作地点</td>
        <td><input name="r_workplace"></td>
    </tr>
    <tr>
        <td>操作</td>
        <td>
            <input type="submit" value="生成招聘信息">
        </td>
    </tr>
</table>
</form>
</body>
</html>