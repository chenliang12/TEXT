<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 13:49
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
                <td colspan="${sessionScope.size}" id="t1">${sessionScope.department.d_depat}</td>
            </tr>
            <tr>
                <c:forEach items="${sessionScope.postitions}" var="de">
                    <td>${de.p_position}</td>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach items="${sessionScope.postitions}" var="de">
                    <c:choose>
                        <c:when test="${de.employee.e_id!=0}">
                            <td><a href="saveemployee.do?id=${de.employee.e_id}">${de.employee.e_name}</a></td>
                        </c:when>
                        <c:when test="${de.employee.e_id==0}">
                            <td>${de.employee.e_name}<a href="deletepos.do?id=${de.p_id}">点击删除该职位</a></td>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>
        <a href="addpos.do?id=${sessionScope.did}">添加职位</a>
    </div>
</div>
</body>
</html>