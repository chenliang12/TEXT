<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/2
  Time: 10:19
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
                <td><a href="saveemploy.do">查看个人信息</a></td>
                <td><a href="saveemps.do">查看其他员工信息</a></td>
                <td><a href="emsavetrain.do">查看培训信息</a></td>
                <td><a href="emsavereandpun.do">查看个人奖惩记录</a></td>
                <td><a href="emsavewages.do">查看个人薪资记录</a></td>
                <td><a href="attendance.do">签到</a></td>
                <td><a href="emsavedissent.do">查看奖惩异议处理进度</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <table border="1">
            <tr>
                <td>基本工资</td>
                <td>绩效工资</td>
                <td>社保</td>
                <td>奖惩工资</td>
                <td>总结算工资</td>
                <td>时间</td>
            </tr>
            <c:forEach items="${sessionScope.wage}" var="wages">
                <tr>
                    <td>${wages.w_bawage}</td>
                    <td>${wages.w_performance}</td>
                    <td>${wages.w_social}</td>
                    <td>${wages.w_reandpun}</td>
                    <td>${wages.w_wages}</td>
                    <td>${wages.w_year}年${wages.w_month}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>