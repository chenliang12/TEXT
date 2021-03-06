<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 21:13
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
                <td>姓名</td>
                <td>奖励</td>
                <td>惩罚</td>
                <td>理由</td>
                <td>时间</td>
                <td>对此处罚有异议</td>
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
                        <c:if test="${reandpun.re_state=='未结算'}">
                            <form action="adddissent.do" method="post">
                                <input name="reason">
                                <input type="hidden" name="id" value="${reandpun.re_id}">
                                <input type="submit" value="提交">
                            </form>
                        </c:if>
                        <c:if test="${reandpun.re_state=='已结算'}">
                            <a>已经结算，无法提异</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>