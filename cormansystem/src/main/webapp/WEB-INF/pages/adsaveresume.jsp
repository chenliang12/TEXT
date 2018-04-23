<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 9:38
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
    应聘岗位：<a>${deli.recruitment.r_job}</a><br>
    <table border="1">
        <tr>
            <td>姓名</td>
            <td>${deli.resume.r_name}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${deli.resume.r_age}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${deli.resume.r_sex}</td>
        </tr>
        <tr>
            <td>籍贯</td>
            <td>${deli.resume.r_origin}</td>
        </tr>
        <tr>
            <td>民族</td>
            <td>${deli.resume.r_family}</td>
        </tr>
        <tr>
            <td>电话</td>
            <td>${deli.resume.r_phone}</td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>${deli.resume.r_email}</td>
        </tr>
        <tr>
            <td>地址</td>
            <td>${deli.resume.r_address}</td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td>${deli.resume.r_campus}</td>
        </tr>
        <tr>
            <td> 工作经历</td>
            <td>${deli.resume.r_jobs}</td>
        </tr>
        <tr>
            <td>个人简介</td>
            <td>${deli.resume.r_evaluation}</td>
        </tr>
        <tr>
            <td>简历状态</td>
            <td>${deli.de_state}</td>
        </tr>
    </table>
    <form method="post" action="updateresume1.do">
        <input type="hidden" value="${deli.de_state}" name="state">
        <input type="hidden" value="${deli.de_id}" name="id">
        <input type="submit" value="通知面试">
        <input type="submit" value="录用">
    </form>
    <form method="post" action="updateresume2.do">
        <input type="hidden" value="${deli.de_state}" name="state">
        <input type="hidden" value="${deli.de_id}" name="id">
        <input type="submit" value="回绝">
    </form>
</c:forEach>
</body>
</html>