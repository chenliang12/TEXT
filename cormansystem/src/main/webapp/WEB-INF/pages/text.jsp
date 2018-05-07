<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/25
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </style>
</head>
<body>
<div id="d1">
    <div id="d2" align="center">
        <table>
            <tr>
                <td><a href="saveresume.do">查看简历</a></td>
                <td><a href="resumestate.do">查看投递状态</a></td>
                <td><a href="companyprofile.do">公司简介</a></td>
                <td><a href="business.do">公司产品展示</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <div id="d1">
            <form method="post" action="upresume.do" onsubmit="return check()">
                姓名：<input id="in1" name="r_name" value="${sessionScope.resume.r_name}" onchange="checkname()"><span id="s1"></span><br>
                年龄：<input id="in2"name="r_age"value="${sessionScope.resume.r_age}" onchange="checkage()"><span id="s2"></span><br>
                籍贯：<input id="in3"name="r_origin" value="${sessionScope.resume.r_origin}" onchange="checkorigin()"><span id="s3"></span><br>
                民族：<input id="in4"name="r_family" value="${sessionScope.resume.r_family}" onchange="checkfamily()"><span id="s4"></span><br>
                手机号码：<input id="in5"name="r_phone" value="${sessionScope.resume.r_phone}" onchange="checkphone()" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')"
            ><span id="s5"></span><br>
                电子邮箱：<input id="in6"name="r_email" value="${sessionScope.resume.r_email}" onchange="checkemail()"><span id="s6"></span><br>
                地址：<input id="in7"name="r_address" value="${sessionScope.resume.r_address}" onchange="checkaddress()"><span id="s7"></span><br>
                毕业院校：<input id="in8"name="r_campus" value="${sessionScope.resume.r_campus}" onchange="checkcampus()"><span id="s8"></span><br>
                工作经历：<input id="in9"name="r_jobs" value="${sessionScope.resume.r_jobs}" onchange="checkjobs()"><span id="s9"></span><br>
                个人评价：<input id="in0"name="r_evaluation" value="${sessionScope.resume.r_evaluation}" onchange="checkevaluation()"><span id="s0"></span><br>
                <input type="submit" value="修改简历">
            </form>
        </div>
        </div>
    </div>
</div>
</body>
</html>