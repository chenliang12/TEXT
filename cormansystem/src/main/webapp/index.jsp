<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/12 0012
  Time: 8:57
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
    <title></title>
</head>
<body>
<fieldset>
    <legend>登录界面</legend>
    <form action="login" method="post">
        账号：<input name="name"><br>
        密码：<input name="pass"><br>
        <input type="submit" value="登录">
    </form>
    <h4 style="color: red">${error}</h4>
</fieldset>
</body>
</html>
