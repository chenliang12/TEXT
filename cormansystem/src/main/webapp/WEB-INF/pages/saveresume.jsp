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
        #d3{
            width: 1000px;
            position: fixed;
            top: 200px;
        }
        #d5{
            background:url("images/bg3.jpg") top center no-repeat;
            height: 150px;
        }
    </style>
</head>
<body>
<div id="d1">
    <div id="d5">

    </div>
    <div id="d2" align="center">
        <table>
            <tr>
                <td><a href="success.do">首页</a> </td>
                <td><a href="saveresume.do">查看简历</a></td>
                <td><a href="resumestate.do">查看投递状态</a></td>
                <td><a href="companyprofile.do">公司简介</a></td>
                <td><a href="business.do">公司产品展示</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
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
</div>
</div>
</body>
</html>