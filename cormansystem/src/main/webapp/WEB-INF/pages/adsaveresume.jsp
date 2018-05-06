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
        <c:forEach items="${sessionScope.delivery}" var="deli">
        <table border="1">
            <tr>
                <td>应聘岗位</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>籍贯</td>
                <td>民族</td>
                <td>电话</td>
                <td>邮箱</td>
                <td>地址</td>
                <td>毕业院校</td>
                <td>工作经历</td>
                <td>个人简介</td>
                <td>简历状态</td>
                <td>操作</td>
            </tr>
            <tr>
                <td>${deli.recruitment.r_job}</td>
                <td>${deli.resume.r_name}</td>
                <td>${deli.resume.r_age}</td>
                <td>${deli.resume.r_sex}</td>
                <td>${deli.resume.r_origin}</td>
                <td>${deli.resume.r_family}</td>
                <td>${deli.resume.r_phone}</td>
                <td>${deli.resume.r_email}</td>
                <td>${deli.resume.r_address}</td>
                <td>${deli.resume.r_campus}</td>
                <td>${deli.resume.r_jobs}</td>
                <td>${deli.resume.r_evaluation}</td>
                <td>${deli.de_state}</td>
                <td>
                    <form method="post" action="updateresume1.do">
                        <input type="hidden" value="${deli.de_state}" name="state">
                        <input type="hidden" value="${deli.de_id}" name="id">
                        <c:if test="${deli.de_state=='已投递'}">
                            <input type="submit" value="通知面试">
                        </c:if>
                        <c:if test="${deli.de_state=='已通知面试'}">
                            <input type="submit" value="录用">
                        </c:if>
                    </form>
                    <c:if test="${deli.de_state=='已投递'}">
                        <form method="post" action="updateresume2.do">
                            <input type="hidden" value="${deli.de_state}" name="state">
                            <input type="hidden" value="${deli.de_id}" name="id">
                            <input type="submit" value="回绝">
                        </form>
                    </c:if>
                </td>
            </tr>
        </table>
        </c:forEach>
    </div>
</div>
</body>
</html>