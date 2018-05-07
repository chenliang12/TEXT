<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 15:03
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
    <script>
        function checkposition() {
            var check=false;
            var position=document.getElementById("in1").value;
            if (position.length==0){
                document.getElementById("sp1").innerHTML="此选项不能为空";
                document.getElementById("sp1").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkwage() {
            var check=false;
            var wage=document.getElementById("in2").value;
            if (wage.length==0){
                document.getElementById("sp2").innerHTML="此选项不能为空";
                document.getElementById("sp2").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function check() {
            var check=checkposition()&&checkwage();
            return check;
        }
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
        <form action="addpostitions.do" method="post" onsubmit="return check()">
            职位名称：<input id="in1" name="p_position" onchange="checkposition()"><span id="sp1"></span><br>
            岗位基本工资：<input id="in2" name="p_wage" onchange="checkwage()" onkeyup="value=value.replace(/[^\d]/g,'')"><span id="sp2"><br>
            <input type="submit" value="创建职位">
        </form>
    </div>
</div>
</body>
</html>