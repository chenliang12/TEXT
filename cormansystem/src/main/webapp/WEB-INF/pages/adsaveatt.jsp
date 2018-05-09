<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/7
  Time: 13:07
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
        <div>
            <form action="saveatt1.do" method="post">
                年份：
                <select name="year">
                    <option value="0">请选择</option>
                    <c:forEach items="${sessionScope.years}" var="depart">
                        <option>${depart}</option>
                    </c:forEach>
                </select>
                月份：
                <select name="month">
                    <option value="0">请选择</option>
                    <option>01</option>
                    <option>02</option>
                    <option>03</option>
                    <option>04</option>
                    <option>05</option>
                    <option>06</option>
                    <option>07</option>
                    <option>08</option>
                    <option>09</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select>
                <input type="hidden" name="num" value="1">
                <input type="submit" value="查询该月记录">
            </form>
        </div>
        <div>
            <table border="1" width="1000px">
                <tr>
                    <td>日期</td>
                    <td>上班时间</td>
                    <td>下班时间</td>
                    <td>打卡状态</td>
                </tr>
                <c:forEach items="${sessionScope.attendances}" var="attendance">
                    <tr>
                        <td>${attendance.date}</td>
                        <td>${attendance.starttime}</td>
                        <td>${attendance.offtime}</td>
                        <td>${attendance.a_state}</td>
                    </tr>
                </c:forEach>
            </table>
            <c:forEach items="${sessionScope.sizes}" var="size">
               <a href="saveatt2.do?num=${size}">${size}</a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>