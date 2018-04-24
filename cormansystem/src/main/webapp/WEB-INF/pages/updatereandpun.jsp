<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 20:36
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
<form action="updatereandpuns.do" method="post">
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <c:if test="${sessionScope.reandpun.re_reward!=0}">
                <td>奖励</td>
            </c:if>
            <c:if test="${sessionScope.reandpun.re_punishment!=0}">
                <td>惩罚</td>
            </c:if>
            <td>理由</td>
            <td>时间</td>
            <td>操作</td>
        </tr>
        <tr>
            <td>${sessionScope.reandpun.re_id}</td>
            <td>${sessionScope.reandpun.employee.e_name}</td>
            <c:if test="${sessionScope.reandpun.re_reward!=0}">
                <td>
                    <input type="hidden" name="num" value="1">
                    <input name="money" value="${sessionScope.reandpun.re_reward}">
                </td>
            </c:if>
            <c:if test="${sessionScope.reandpun.re_punishment!=0}">
                <td>
                    <input type="hidden" name="num" value="0">
                    <input name="money" value="${sessionScope.reandpun.re_punishment}">
                </td>
            </c:if>
            <td>
                <input name="explanation" value="${sessionScope.reandpun.re_explanation}">
            </td>
            <td>${sessionScope.reandpun.re_date}</td>
            <td>
                <input type="hidden" name="id" value="${sessionScope.reandpun.re_id}">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>