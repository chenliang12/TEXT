<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/25
  Time: 11:32
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#dep").change(function () {
                var depid=$(this).val()
                $.ajax({
                    url:"moveofpersonnelajax.do",
                    data:{"depid":depid},
                    javaType:"json",
                    success:function (postitions) {
                        $("#pos").empty()
                        var post=eval(postitions)
                        var str="";
                        $.each(postitions,function (index,value) {
                            str+="<option value="+value.p_id+">"+value.p_position+"</option>"
                        })
                        $("#pos").append(str)
                    }
                })
            })
        })
    </script>
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
        <div>
            <form action="replace.do" method="post">
                部门：
                <select id="dep" name="depid">
                    <option value="0">请选择</option>
                    <c:forEach items="${sessionScope.departmentList}" var="depart">
                        <option value="${depart.d_id}">${depart.d_depat}</option>
                    </c:forEach>
                </select><br/>
                职位：
                <select id="pos" name="posid">
                    <option value="0">请选择</option>
                </select><br/>
                <input type="hidden" value="${sessionScope.employee.e_id}" name="eid">
                <input type="submit" value="确定换岗">
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>