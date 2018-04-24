<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 9:52
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
        <td colspan="${sessionScope.size}" align="center">公司部门</td>
    </tr>
    <tr>
        <c:forEach items="${sessionScope.department}" var="de">
            <td><a href="saveempes.do?id=${de.d_id}">${de.d_depat}</a></td>
        </c:forEach>
    </tr>
</table>
</body>
</html>