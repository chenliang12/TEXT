<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/2
  Time: 9:10
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
            <td>基本工资</td>
            <td>绩效工资</td>
            <td>社保</td>
            <td>奖惩工资</td>
            <td>总结算工资</td>
            <td>时间</td>
        </tr>
        <c:forEach items="${sessionScope.wage}" var="wages">
            <tr>
                <td>${wages.w_bawage}</td>
                <td>${wages.w_performance}</td>
                <td>${wages.w_social}</td>
                <td>${wages.w_reandpun}</td>
                <td>${wages.w_wages}</td>
                <td>${wages.w_year}年${wages.w_month}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>