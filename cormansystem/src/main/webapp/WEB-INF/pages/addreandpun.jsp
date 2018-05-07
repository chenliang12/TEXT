<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 19:24
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
        function checkmoney() {
            var check=false;
            var money=document.getElementById("in1").value;
            if (money.length==0){
                document.getElementById("sp1").innerHTML="此选项不能为空";
                document.getElementById("sp1").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkexplanation() {
            var check=false;
            var explanation=document.getElementById("in2").value;
            if (explanation.length==0){
                document.getElementById("sp2").innerHTML="此选项不能为空";
                document.getElementById("sp2").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkename() {
            var check=false;
            var ename=document.getElementById("in3").value;
            if (ename.length==0){
                document.getElementById("sp3").innerHTML="此选项不能为空";
                document.getElementById("sp3").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }function checkpostition() {
            var check=false;
            var postition=document.getElementById("in4").value;
            if (postition.length==0){
                document.getElementById("sp4").innerHTML="此选项不能为空";
                document.getElementById("sp4").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function check() {
            var check=checkename()&&checkexplanation()&&checkmoney()&&checkpostition();
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
        }  #d5{
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
        <form method="post" action="adaddreandpun.do" onsubmit="return check()">
            奖惩金额：<input id="in1" name="money" onchange="checkmoney()" onkeyup="value=value.replace(/[^\d]/g,'')"><span id="sp1"></span><br>
            理由：<input id="in2"name="explanation" onchange="checkexplanation()"><span id="sp2"></span><br>
            奖惩对象：<input id="in3"name="ename" onchange="checkename()"><span id="sp3"></span><br>
            所在职位：<input id="in4" name="postition" onchange="checkpostition()"><span id="sp4"></span><br>
            奖励：<input type="radio" id="in5" name="name" value="1" >
            处罚：<input type="radio" id="in6" name="name" value="0" ><span id="sp5"></span>
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</div>
</body>
</html>