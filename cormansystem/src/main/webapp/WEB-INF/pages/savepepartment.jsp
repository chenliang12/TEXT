<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 13:17
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
        #d5{
            background:url("images/bg3.jpg") top center no-repeat;
            height: 150px;
        }
        #t1{
            font-size: 30px;
        }
        td{
            text-align: center;
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
        <table border="1" width="1000px">
            <tr>
                <td colspan="${sessionScope.size}" id="t1">公司部门</td>
            </tr>
            <tr>
                <c:forEach items="${sessionScope.department}" var="de">
                    <td><a href="savepostitions.do?id=${de.d_id}">${de.d_depat}</a></td>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach items="${sessionScope.department}" var="de">
                    <td><a href="deletedepart.do?id=${de.d_id}">删除部门</a></td>
                </c:forEach>
            </tr>
        </table>
        <a href="adddepar.do">添加部门</a>
    </div>
</div>
</body>
</html>