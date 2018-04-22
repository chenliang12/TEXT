<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 19:14
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
        姓名：<a>${sessionScope.resume.r_name}</a><br>
        年龄：<a>${sessionScope.resume.r_age}</a><br>
        籍贯：<a>${sessionScope.resume.r_origin}</a><br>
        民族：<a>${sessionScope.resume.r_family}</a><br>
        手机号码：<a>${sessionScope.resume.r_phone}</a><br>
        电子邮箱：<a>${sessionScope.resume.r_email}</a><br>
        地址：<a>${sessionScope.resume.r_address}</a><br>
        毕业院校：<a>${sessionScope.resume.r_campus}</a><br>
        工作经历：<a>${sessionScope.resume.r_jobs}</a><br>
        个人评价：<a>${sessionScope.resume.r_evaluation}</a><br>
        <a href="updateresume.do">修改简历</a>
</div>
</body>
</html>