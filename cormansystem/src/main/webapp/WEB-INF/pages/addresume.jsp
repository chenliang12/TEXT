<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 18:56
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
<div id="d1">
    <form method="post" action="addresume.do">
        姓名：<input name="r_name"><br>
        年龄：<input name="r_age"><br>
        性别：<input name="r_sex"><br>
        籍贯：<input name="r_origin"><br>
        民族：<input name="r_family"><br>
        手机号码：<input name="r_phone"><br>
        电子邮箱：<input name="r_email"><br>
        地址：<input name="r_address"><br>
        毕业院校：<input name="r_campus"><br>
        工作经历：<input name="r_jobs"><br>
        个人评价：<input name="r_evaluation"><br>
        <input type="submit" value="添加简历">
    </form>
</div>
</body>
</html>