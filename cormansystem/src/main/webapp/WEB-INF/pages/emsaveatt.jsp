<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/27
  Time: 13:34
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
    <script src="js/jquery-3.1.0.js"></script>
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
        <div>
            <form action="saveattendance1.do" method="post">
                年份：
                <select name="year">
                    <option value="0">请选择</option>
                    <c:forEach items="${sessionScope.years}" var="depart">
                        <option>${depart}</option>
                    </c:forEach>
                </select><br/>
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
                </select><br/>
                <input type="submit" value="查询该月记录">
            </form>
        </div>
        <div>
            <table border="1">
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
        </div>
    </div>
</div>
</body>
</html>