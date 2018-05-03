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
    <style>
        #d1{
            width: 1000px;
            height: 10000px;
            position: fixed;
            background-color:bisque;
            left: 450px;
        }
        #d2{
            width: 1000px;
            background-color:chartreuse;
            position: fixed;
            top: 150px;
        }
    </style>
</head>
<body>
<div id="d1">
    <div id="d3">
        <div id="d2" align="center">
            <table>
                <tr>
                    <td><a href="adminsaverecrui.do">查看发布的招聘信息</a></td>
                    <td><a href="adminsaveresume.do">查看接收的简历</a></td>
                    <td><a href="savedepartment.do">查看各部门信息</a></td>
                    <td><a href="adsavetrain.do">安排培训事宜</a></td>
                    <td><a href="adsavereandpun.do">管理员工奖惩信息</a></td>
                    <td><a href="adsavedissents.do">查看奖惩异议信息</a> </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>