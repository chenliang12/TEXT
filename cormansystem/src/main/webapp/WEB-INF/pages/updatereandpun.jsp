<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 20:36
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
        <form action="updatereandpuns.do" method="post">
            <table border="1">
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <c:if test="${sessionScope.reandpun.re_reward!=0}">
                        <td>奖励</td>
                    </c:if>
                    <c:if test="${sessionScope.reandpun.re_punishment!=0}">
                        <td>惩罚</td>
                    </c:if>
                    <td>理由</td>
                    <td>时间</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td>${sessionScope.reandpun.re_id}</td>
                    <td>${sessionScope.reandpun.employee.e_name}</td>
                    <c:if test="${sessionScope.reandpun.re_reward!=0}">
                        <td>
                            <input type="hidden" name="num" value="1">
                            <input name="money" value="${sessionScope.reandpun.re_reward}">
                        </td>
                    </c:if>
                    <c:if test="${sessionScope.reandpun.re_punishment!=0}">
                        <td>
                            <input type="hidden" name="num" value="0">
                            <input name="money" value="${sessionScope.reandpun.re_punishment}">
                        </td>
                    </c:if>
                    <td>
                        <input name="explanation" value="${sessionScope.reandpun.re_explanation}">
                    </td>
                    <td>${sessionScope.reandpun.re_date}</td>
                    <td>
                        <input type="hidden" name="id" value="${sessionScope.reandpun.re_id}">
                        <input type="submit" value="修改">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</div>
</body>
</html>