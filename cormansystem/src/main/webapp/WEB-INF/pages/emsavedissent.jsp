<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/2
  Time: 16:05
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
        <td>编号</td>
        <td>奖惩记录编号</td>
        <td>奖惩记录时间</td>
        <td>奖惩记录原因</td>
        <td>异议内容</td>
        <td>状态</td>
    </tr>
    <c:forEach items="${sessionScope.dissents}" var="dissent">
        <tr>
            <td>${dissent.d_id}</td>
            <td>${dissent.reandpun.re_id}</td>
            <td>${dissent.reandpun.date}</td>
            <td>${dissent.reandpun.re_explanation}</td>
            <td>${dissent.d_reason}</td>
            <td>${dissent.d_state}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>