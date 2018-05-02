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

</head>
<body>
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
</body>
</html>