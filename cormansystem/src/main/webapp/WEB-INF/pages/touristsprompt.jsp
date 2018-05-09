<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/7
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
            font-size: 40px;
            text-align: center;
            color: red;
            left: 450px;
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
                <td><a href="success.do">首页</a> </td>
                <td><a href="saveresume.do">查看简历</a></td>
                <td><a href="resumestate.do">查看投递状态</a></td>
                <td><a href="companyprofile.do">公司简介</a></td>
                <td><a href="business.do">公司产品展示</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
        ${sessionScope.prompt}
            <c:if test="${sessionScope.prompt=='您还没有创建简历'}">
                <a href="addresumes.do">创建简历</a>
            </c:if>
            <c:if test="${sessionScope.prompt=='您目前游客身份无法进行此操作，请先注册'}">
                <a href="addusers.do">注册账号</a>
            </c:if>
    </div>
</div>
</div>
</body>
</html>