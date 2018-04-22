<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 16:32
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#name").blur(function () {
                $.ajax({
                    type:"post",
                    url:"checkname.do",
                    data:"name="+$(this).val(),
                    success:function (date) {
                        $("#sp1").html(date)
                    }
                })
            })
        })
    </script>
</head>
<body>
<form action="adduser.do" method="post">
    账号：<input id="name" name="uname"><span id="sp1"></span><br>
    密码：<input name="upass"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>