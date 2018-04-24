<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 12:40
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
<form method="post" action="addtrain.do">
    <table border="1">
        <tr>
            <td>培训主题</td>
            <td><input name="t_title"></td>
        </tr>
        <tr>
            <td>培训内容</td>
            <td><input name="t_content"></td>
        </tr>
        <tr>
            <td>培训地点</td>
            <td><input name="t_address"></td>
        </tr>
        <tr>
            <td>培训时间</td>
            <td><input name="t_date"></td>
        </tr>
        <tr>
            <td>培训部门</td>
            <td><input name="depname"></td>
        </tr>
    </table>
    <input type="submit" value="创建培训">
</form>
</body>
</html>