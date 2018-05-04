<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 14:46
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
        .t{
            width: 300px;
        }
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
                <td><a href="adminsaverecrui.do">查看发布的招聘信息</a></td>
                <td><a href="adminsaveresume.do">查看接收的简历</a></td>
                <td><a href="savedepartment.do">查看各部门信息</a></td>
                <td><a href="adsavetrain.do">安排培训事宜</a></td>
                <td><a href="adsavereandpun.do">管理员工奖惩信息</a></td>
                <td><a href="adsavedissents.do">查看奖惩异议信息</a> </td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <table border="1">
            <tr>
                <td>姓名</td>
                <td>${sessionScope.employee.e_name}</td>
            </tr>
            <tr>
                <td>年龄</td>
                <td>${sessionScope.employee.e_age}</td>
            </tr>
            <tr>
                <td>籍贯</td>
                <td>${sessionScope.employee.e_origin}</td>
            </tr>
            <tr>
                <td>性别</td>
                <td>${sessionScope.employee.e_sex}</td>
            </tr>
            <tr>
                <td>手机号码</td>
                <td>${sessionScope.employee.e_phone}</td>
            </tr>
            <tr><!--date日期转化年月日-->
                <td>入职时间</td>
                <td>${sessionScope.employee.date}</td>
            </tr>
            <tr>
                <td>状态</td>
                <td>${sessionScope.employee.e_state}
                    <c:if test="${sessionScope.employee.e_state=='实习'}">
                        <form method="post" action="upemployee.do">
                            <input type="hidden" name="id" value="${sessionScope.employee.e_id}">
                            <input type="submit" value="转正">
                        </form>
                    </c:if>
                    <c:if test="${sessionScope.employee.e_state=='正式工'}">
                        <form method="post" action="upemployee.do">
                            <input type="hidden" name="id" value="${sessionScope.employee.e_id}">
                            <input type="submit" value="辞退">
                        </form>
                    </c:if></td>
            </tr>
            <tr>
                <td>离职原因</td>
                <td>${sessionScope.employee.e_reason}

                </td>
            </tr>
            <tr>
                <td>人事调动</td>
                <td><a href="moveofpersonnel.do?id=${sessionScope.employee.e_id}">员工调动安排</a></td>
            </tr>
            <tr>
                <td>查看打卡记录</td>
                <td><a href="saveatt.do?id=${sessionScope.employee.e_id}">查看员工打卡记录</a></td>
            </tr>
            <tr>
                <td>薪资结算</td>
                <td><a href="settwage.do?id=${sessionScope.employee.e_id}">结算上月工资</a></td>
            </tr>
            <tr>
                <td>查看薪资记录</td>
                <td><a href="savewage.do?id=${sessionScope.employee.e_id}">查询</a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>