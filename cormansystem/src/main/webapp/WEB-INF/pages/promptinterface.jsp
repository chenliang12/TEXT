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
        #d5{
            background:url("images/bg3.jpg") top center no-repeat;
            height: 150px;
        }
    </style>
</head>
<body>
<div id="d1">
    <div id="d5">

    </div>
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
        ${sessionScope.prompt}
        <c:if test="${sessionScope.prompt=='公司目前没有部门创建'}">
            <a href="adddepar.do">添加部门</a>
        </c:if>
        <c:if test="${sessionScope.prompt=='该部门目前没有职位'}">
            <a href="addpos.do?id=${sessionScope.did}">添加职位</a>
        </c:if>
        <c:if test="${sessionScope.prompt=='目前没有培训信息'}">
            <a href="addtrains.do">添加培训计划</a>
        </c:if>
        <c:if test="${sessionScope.prompt=='目前没有奖惩记录'}">
            <a href="addreandpun.do">增加奖惩信息</a>
        </c:if>
    </div>
</div>
</body>
</html>