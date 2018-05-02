<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/30
  Time: 10:10
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
</head>
<body>
<form action="settwage1.do" method="post">
    <table>
        <tr>
            <td>基本工资</td>
            <td>${sessionScope.wage.w_bawage}</td>
        </tr>
        <tr>
            <td>绩效工资</td>
            <td>
                <input name="w_performance">
            </td>
        </tr>
        <tr>
            <td>社保</td>
            <td>${sessionScope.wage.w_social}</td>
        </tr>
        <tr>
            <td>奖惩工资</td>
            <td>${sessionScope.wage.w_reandpun}</td>
        </tr>
        <tr>
            <td>操作</td>
            <td>
                <input type="submit" value="生成工资单">
            </td>
        </tr>
    </table>
</form>

</body>
</html>