<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/5/3
  Time: 9:00
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
                <td><a href="adminsaverecrui.do">查看发布的招聘信息</a></td>
                <td><a href="adminsaveresume.do">查看接收的简历</a></td>
                <td><a href="savedepartment.do">查看各部门信息</a></td>
                <td><a href="adsavetrain.do">安排培训事宜</a></td>
                <td><a href="adsavedissents.do">查看奖惩异议信息</a> </td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <a href="adsavedissents1.do">查看已解决信息</a>
        <a href="adsavedissents.do">查看未解决信息</a>
        <table border="1" width="1000px">
            <tr>
                <td>编号</td>
                <td>奖惩记录编号</td>
                <td>提交人</td>
                <td>奖惩记录时间</td>
                <td>奖惩记录原因</td>
                <td>异议内容</td>
                <td>状态</td>
                <c:if test="${sessionScope.state==1}">
                    <td>操作</td>
                </c:if>
            </tr>
            <c:forEach items="${sessionScope.dissents}" var="dissent">
                <tr>
                    <td>${dissent.d_id}</td>
                    <td>${dissent.reandpun.re_id}</td>
                    <td>${dissent.employee.e_name}</td>
                    <td>${dissent.reandpun.date}</td>
                    <td>${dissent.reandpun.re_explanation}</td>
                    <td>${dissent.d_reason}</td>
                    <td>${dissent.d_state}</td>
                    <c:if test="${sessionScope.state==1}">
                        <td>
                            <form action="updatedissents.do" method="post">
                                <input type="hidden" value="1" name="num">
                                <input type="hidden" value="${dissent.d_id}" name="id">
                                <input type="submit" value="同意修改">
                            </form>
                        </td>
                        <td>
                            <form action="updatedissents.do" method="post">
                                <input type="hidden" value="0" name="num">
                                <input type="hidden" value="${dissent.d_id}" name="id">
                                <input type="submit" value="驳回">
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>