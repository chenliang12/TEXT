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
    <form action="login.do" method="post">
        账号：<input name="uname"><br>
        密码：<input name="upass"><br>
        <input type="submit" value="登录">
    </form>
    <a href="addusers.do">还没有账号？点击此处注册</a>
    <a href="tourists.do">游客入口</a>
</fieldset>
</body>
</html>
