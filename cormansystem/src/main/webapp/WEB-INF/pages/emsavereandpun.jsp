<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 21:13
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
<table border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>奖励</td>
        <td>惩罚</td>
        <td>理由</td>
        <td>时间</td>
    </tr>
    <c:forEach items="${sessionScope.reandpuns}" var="reandpun">
        <tr>
            <td>${reandpun.re_id}</td>
            <td>${reandpun.employee.e_name}</td>
            <td>${reandpun.re_reward}</td>
            <td>${reandpun.re_punishment}</td>
            <td>${reandpun.re_explanation}</td>
            <td>${reandpun.re_date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>