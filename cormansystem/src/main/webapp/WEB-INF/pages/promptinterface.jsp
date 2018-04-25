<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/25
  Time: 15:38
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
        #d1{
            align-content: center;
        }
    </style>
</head>
<body>
<div id="d1">
    ${sessionScope.prompt}
        <c:if test="${sessionScope.prompt=='公司目前没有部门创建'}">
            <a href="adddepar.do">添加部门</a>
        </c:if>
        <c:if test="${sessionScope.prompt=='该部门目前没有职位'}">
            <a href="addpos.do?id=${sessionScope.did}">添加职位</a>
        </c:if>
</div>
</body>
</html>