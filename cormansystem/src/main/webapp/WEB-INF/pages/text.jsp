<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/25
  Time: 9:35
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
        .t{
            width: 300px;
        }
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
                <td>编号</td>
                <td>奖惩记录编号</td>
                <td>奖惩记录时间</td>
                <td>奖惩记录原因</td>
                <td>异议内容</td>
                <td>状态</td>
            </tr>
            <c:forEach items="${sessionScope.dissents}" var="dissent">
                <tr>
                    <td>${dissent.d_id}</td>
                    <td>${dissent.reandpun.re_id}</td>
                    <td>${dissent.reandpun.date}</td>
                    <td>${dissent.reandpun.re_explanation}</td>
                    <td>${dissent.d_reason}</td>
                    <td>${dissent.d_state}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>