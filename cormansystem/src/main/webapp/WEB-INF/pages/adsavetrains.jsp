<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 10:39
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
                <td><a href="adminsaverecrui.do">查看发布的招聘信息</a></td>
                <td><a href="adminsaveresume.do">查看接收的简历</a></td>
                <td><a href="savedepartment.do">查看各部门信息</a></td>
                <td><a href="adsavetrain.do">安排培训事宜</a></td>
                <td><a href="adsavedissents.do">查看奖惩异议信息</a> </td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <a href="addtrains.do">添加培训计划</a>
        <table border="1" width="1000px">
            <tr>
                <td>培训主题</td>
                <td>培训内容</td>
                <td>培训地址</td>
                <td>培训时间</td>
                <td>培训进度</td>
                <td>培训部门</td>
                <td>操作</td>
                <td>删除</td>
            </tr>
        <c:forEach items="${sessionScope.trains}" var="train">
                <tr>
                    <td>${train.t_title}</td>
                    <td>${train.t_content}</td>
                    <td>${train.t_address}</td>
                    <td>${train.t_date}</td>
                    <td>${train.t_state}</td>
                    <td>${train.department.d_depat}</td>
                    <td>
            <c:if test="${train.t_state=='未培训'}">
                <form action="updatetrain.do" method="post">
                    <input type="hidden" name="id" value="${train.t_id}">
                    <input type="submit" value="完结培训">
                </form>
            </c:if>
                    </td>
                    <td>
                        <c:if test="${train.t_state=='未培训'}">
                            <form action="deletetrain.do" method="post">
                                <input type="hidden" name="id" value="${train.t_id}">
                                <input type="submit" value="删除培训">
                            </form>
                        </c:if>
                    </td>
                </tr>
        </c:forEach>
        </table>
    </div>
</div>
</body>
</html>