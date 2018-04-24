<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 10:39
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
<a href="addtrains.do">添加培训计划</a>
<c:forEach items="${sessionScope.trains}" var="train">
    <table border="1">
        <tr>
            <td>培训主题</td>
            <td>${train.t_title}</td>
        </tr>
        <tr>
            <td>培训内容</td>
            <td>${train.t_content}</td>
        </tr>
        <tr>
            <td>培训地址</td>
            <td>${train.t_address}</td>
        </tr>
        <tr>
            <td>培训时间</td>
            <td>${train.t_date}</td>
        </tr>
        <tr>
            <td>培训进度</td>
            <td>${train.t_state}</td>
        </tr>
        <tr>
            <td>培训部门</td>
            <td>${train.department.d_depat}</td>
        </tr>
        <c:if test="${train.t_state=='未培训'}">
            <tr>
                <td>操作</td>
                <td>
                    <form action="updatetrain.do" method="post">
                        <input type="hidden" name="id" value="${train.t_id}">
                        <input type="submit" value="完结培训">
                    </form>
                </td>
            </tr>
        </c:if>
    </table>
</c:forEach>
</body>
</html>