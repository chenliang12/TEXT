<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 19:07
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
            width: 1000px;
            height: 10000px;
            position: fixed;
            background-color:bisque;
            left: 450px;
        }
        #d2{
            width: 1000px;
            background-color:chartreuse;
            position: fixed;
            top: 150px;
        }
        #d3{
            width: 1000px;
            position: fixed;
            top: 200px;
        }
    </style>
</head>
<body>
<div id="d1">
    <div id="d2" align="center">
        <table>
            <tr>
                <td><a href="adminsaverecrui.do">查看发布的招聘信息</a></td>
                <td><a href="adminsaveresume.do">查看接收的简历</a></td>
                <td><a href="savedepartment.do">查看各部门信息</a></td>
                <td><a href="adsavetrain.do">安排培训事宜</a></td>
                <td><a href="adsavedissents.do">查看奖惩异议信息</a> </td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <a href="addreandpun.do">增加奖惩信息</a>
        <a href="adsavereandpun1.do?id=${sessionScope.employee.e_id}">查看已结算信息</a>
        <a href="adsavereandpun.do?id=${sessionScope.employee.e_id}">查看未结算信息</a>
        <table border="1">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>奖励</td>
                <td>惩罚</td>
                <td>理由</td>
                <td>时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.reandpuns}" var="reandpun">
                <tr>
                    <td>${reandpun.re_id}</td>
                    <td>${reandpun.employee.e_name}</td>
                    <td>${reandpun.re_reward}</td>
                    <td>${reandpun.re_punishment}</td>
                    <td>${reandpun.re_explanation}</td>
                    <td>${reandpun.date}</td>
                    <td>
                        <form action="updatereandpun.do" method="post">
                            <input type="hidden" name="id" value="${reandpun.re_id}">
                            <input type="submit" value="修改">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>