<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 20:23
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
<a href="saveemploy.do">查看个人信息</a>
<a href="saveemps.do">查看其他员工信息</a>
<a href="emsavetrain.do">查看培训信息</a>
<a href="emsavereandpun.do">查看个人奖惩记录</a>
<a href="emsavewages.do">查看个人薪资记录</a>
<a href="attendance.do">签到</a>
<a href="emsavedissent.do">查看奖惩异议处理进度</a>
</body>
</html>