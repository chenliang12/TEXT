<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/3
  Time: 9:00
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
        <td>提交人</td>
        <td>奖惩记录时间</td>
        <td>奖惩记录原因</td>
        <td>异议内容</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${sessionScope.dissents}" var="dissent">
        <tr>
            <td>${dissent.d_id}</td>
            <td>${dissent.reandpun.re_id}</td>
            <td>${dissent.employee.e_name}</td>
            <td>${dissent.reandpun.date}</td>
            <td>${dissent.reandpun.re_explanation}</td>
            <td>${dissent.d_reason}</td>
            <td>${dissent.d_state}</td>
            <td>
                <form action="updatedissents.do" method="post">
                    <input type="hidden" value="1" name="num">
                    <input type="hidden" value="${dissent.d_id}" name="id">
                    <input type="submit" value="同意修改">
                </form>
            </td>
            <td>
                <form action="updatedissents.do" method="post">
                    <input type="hidden" value="0" name="num">
                    <input type="hidden" value="${dissent.d_id}" name="id">
                    <input type="submit" value="驳回">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>