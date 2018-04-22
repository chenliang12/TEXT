<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/20
  Time: 15:01
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
    <script src="../../js/jquery-3.1.0.js"></script>
    <script>
    </script>
    <style>
       .t{
           width: 300px;
       }
        #d1{
            width: 700px;
            height: 400px;
        }
    </style>
</head>
<body>
<a href="saveresume.do">查看简历</a>
<div id="d1">
    <c:forEach items="${sessionScope.recruitments}" var="recruitment">
        <table border="1">
            <tr>
                <td>职位</td>
                <td class="t">${recruitment.r_job}</td>
            </tr>
            <tr>
                <td>基本工资</td>
                <td class="t">${recruitment.r_wage}</td>
            </tr>
            <tr>
                <td>工作要求</td>
                <td class="t">${recruitment.r_demand}</td>
            </tr>
            <tr>
                <td>待遇</td>
                <td class="t">${recruitment.r_treatment}</td>
            </tr>
            <tr>
                <td>工作地点</td>
                <td class="t">${recruitment.r_workplace}</td>
            </tr>
            <tr>
                <td>状态</td>
                <td class="t">${recruitment.r_state}</td>
            </tr>
            <tr>
                <td>发布时间</td>
                <td class="t">${recruitment.r_createtime}</td>
            </tr>
            <tr>
                <td>发布时间</td>
                <td class="t">
                    <form method="post" action="choosere.do">
                        <input type="hidden" name="id" value="${recruitment.r_id}">
                        <input type="submit" value="投递简历">
                    </form>
                </td>
            </tr>
        </table>
    </c:forEach>
</div>
</body>
</html>