<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 19:22
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
    <form method="post" action="upresume.do">
        姓名：<input name="r_name" value="${sessionScope.resume.r_name}"><br>
        年龄：<input name="r_age"value="${sessionScope.resume.r_age}"><br>
        籍贯：<input name="r_origin" value="${sessionScope.resume.r_origin}"><br>
        民族：<input name="r_family" value="${sessionScope.resume.r_family}"><br>
        手机号码：<input name="r_phone" value="${sessionScope.resume.r_phone}"><br>
        电子邮箱：<input name="r_email" value="${sessionScope.resume.r_email}"><br>
        地址：<input name="r_address" value="${sessionScope.resume.r_address}"><br>
        毕业院校：<input name="r_campus" value="${sessionScope.resume.r_campus}"><br>
        工作经历：<input name="r_jobs" value="${sessionScope.resume.r_jobs}"><br>
        个人评价：<input name="r_evaluation" value="${sessionScope.resume.r_evaluation}"><br>
        <input type="submit" value="修改简历">
    </form>
</div>
</body>
</html>