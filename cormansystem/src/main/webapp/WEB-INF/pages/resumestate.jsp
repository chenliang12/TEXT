<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 12:26
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
<c:forEach items="${sessionScope.delivery}" var="deli">
    <table border="1">
        <tr>
            <td>投递职位</td>
            <td>${deli.recruitment.r_job}</td>
        </tr>
        <tr>
            <td>目前状态</td>
            <td>${deli.de_state}</td>
        </tr>
    </table>
</c:forEach>
</body>
</html>