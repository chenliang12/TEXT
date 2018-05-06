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
                <td><a href="adminsaverecrui.do">查看发布的招聘信息</a></td>
                <td><a href="adminsaveresume.do">查看接收的简历</a></td>
                <td><a href="savedepartment.do">查看各部门信息</a></td>
                <td><a href="adsavetrain.do">安排培训事宜</a></td>
                <td><a href="adsavedissents.do">查看奖惩异议信息</a> </td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <a href="addrecruiments.do">添加招聘信息</a>
        <table border="1">
            <tr>
                <td>职位</td>
                <td>基本工资</td>
                <td>工作要求</td>
                <td>待遇</td>
                <td>工作地点</td>
                <td>状态</td>
                <td>发布时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.recruitments}" var="recruitment">
                <tr>
                    <td class="t">${recruitment.r_job}</td>
                    <td class="t">${recruitment.r_wage}</td>
                    <td class="t">${recruitment.r_demand}</td>
                    <td class="t">${recruitment.r_treatment}</td>
                    <td class="t">${recruitment.r_workplace}</td>
                    <td class="t">${recruitment.r_state}</td>
                    <td class="t">${recruitment.createtime}</td>
                    <td class="t">
                        <form method="post" action="deleterecru.do">
                            <input type="hidden" name="id" value="${recruitment.r_id}">
                            <input type="submit" value="删除此招聘信息">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>