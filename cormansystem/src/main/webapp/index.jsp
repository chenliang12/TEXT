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
    <style>
        #d1{
            height: 600px;
            width:  500px;
            position: fixed;
            left: 1000px;
            bottom: 100px;
        }
        body {
            background: url('images/bg1.jpg')top center no-repeat;
            background-size:cover;
        }
        .a1{
           font-size: 30px;
        }
        .in1{
            height: 50px;
            width: 300px;
        }
        .in2{
            height: 50px;
            width: 50px;
        }
    </style>
</head>
<body>
<div id="d1">
    <fieldset>
        <legend class="a1">登录界面</legend>
        <form action="login.do" method="post">
            <a class="a1">账号：</a><input class="in1" name="uname"><br>
            <a class="a1">密码：</a><input class="in1" type="password" name="upass">
            <input class="in2" type="submit" value="登录">
        </form>
        <a class="a1" href="addusers.do">还没有账号？点击此处注册</a>
        <a class="a1" href="tourists.do">游客入口</a>
    </fieldset>
</div>
</body>
</html>
