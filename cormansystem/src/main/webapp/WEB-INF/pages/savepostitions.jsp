<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 13:49
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
    <style>

    </style>
</head>
<body>
<table border="1">
    <tr>
        <td colspan="${sessionScope.size}" align="center">${sessionScope.department.d_depat}</td>
    </tr>
    <tr>
        <c:forEach items="${sessionScope.postitions}" var="de">
            <td>${de.p_position}</td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${sessionScope.postitions}" var="de">
            <c:choose>
                <c:when test="${de.employee.e_id!=0}">
                    <td><a href="saveemployee.do?id=${de.employee.e_id}">${de.employee.e_name}</a></td>
                </c:when>
                <c:when test="${de.employee.e_id==0}">
                    <td>${de.employee.e_name}<a href="">点击删除该职位</a> </td>
                </c:when>
            </c:choose>
        </c:forEach>
    </tr>
</table>
</body>
</html>