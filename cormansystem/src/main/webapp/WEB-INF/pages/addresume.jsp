<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 18:56
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
        function checkname() {
            var check=false;
            var name=document.getElementById("in1").value;
            if (name.length==0){
                document.getElementById("s1").innerHTML="此选项不能为空";
                document.getElementById("s1").style.color='red';
                check=false;
            }else {
                document.getElementById("s1").innerHTML="✔";
                document.getElementById("s1").style.color='green';
                check=true;
            }
            return check;
        }
        function checkorigin() {
            var check=false;
            var origin=document.getElementById("in3").value;
            if (origin.length==0){
                document.getElementById("s3").innerHTML="此选项不能为空";
                document.getElementById("s3").style.color='red';
                check=false;
            }else {
                document.getElementById("s3").innerHTML="✔";
                document.getElementById("s3").style.color='green';
                check=true;
            }
            return check;
        }
        function checkage() {
            var check=false;
            var age=document.getElementById("in2").value;
            if (age.length==0){
                document.getElementById("s2").innerHTML="此选项不能为空";
                document.getElementById("s2").style.color='red';
                check=false;
            }else {
                document.getElementById("s2").innerHTML="✔";
                document.getElementById("s2").style.color='green';
                check=true;
            }
            return check;
        }
        function checkfamily() {
            var check=false;
            var family=document.getElementById("in4").value;
            if (family.length==0){
                document.getElementById("s4").innerHTML="此选项不能为空";
                document.getElementById("s4").style.color='red';
                check=false;
            }else {
                document.getElementById("s4").innerHTML="✔";
                document.getElementById("s4").style.color='green';
                check=true;
            }
            return check;
        }
        function checkphone() {
            var check=false;
            var phone=document.getElementById("in5").value;
            if (phone.length==0){
                document.getElementById("s5").innerHTML="此选项不能为空";
                document.getElementById("s5").style.color='red';
                check=false;
            }else if(phone.length<11){
                document.getElementById("s5").innerHTML="手机号码请填写11位数";
                document.getElementById("s5").style.color='red';
                check=false;
            } else {
                document.getElementById("s5").innerHTML="✔";
                document.getElementById("s5").style.color='green';
                check=true;
            }
            return check;
        }
        function checkemail() {
            var check=false;
            var email=document.getElementById("in6").value;
            var emails = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; //验证Email
            if (email.length==0){
                document.getElementById("s6").innerHTML="此选项不能为空";
                document.getElementById("s6").style.color='red';
                check=false;
            }else if (!emails.test(email)){
                document.getElementById("s6").innerHTML="请输入正确的邮箱地址";
                document.getElementById("s6").style.color='red';
                check=false;
            } else{
                document.getElementById("s6").innerHTML="✔";
                document.getElementById("s6").style.color='green';
                check=true;
            }
            return check;
        }
        function checkaddress() {
            var check=false;
            var address=document.getElementById("in7").value;
            if (address.length==0){
                document.getElementById("s7").innerHTML="此选项不能为空";
                document.getElementById("s7").style.color='red';
                check=false;
            }else {
                document.getElementById("s7").innerHTML="✔";
                document.getElementById("s7").style.color='green';
                check=true;
            }
            return check;
        }
        function checkcampus() {
            var check=false;
            var campus=document.getElementById("in8").value;
            if (campus.length==0){
                document.getElementById("s8").innerHTML="此选项不能为空";
                document.getElementById("s8").style.color='red';
                check=false;
            }else {
                document.getElementById("s8").innerHTML="✔";
                document.getElementById("s8").style.color='green';
                check=true;
            }
            return check;
        }
        function checkjobs() {
            var check=false;
            var jobs=document.getElementById("in9").value;
            if (jobs.length==0){
                document.getElementById("s9").innerHTML="此选项不能为空";
                document.getElementById("s9").style.color='red';
                check=false;
            }else {
                document.getElementById("s9").innerHTML="✔";
                document.getElementById("s9").style.color='green';
                check=true;
            }
            return check;
        }
        function checkevaluation() {
            var check=false;
            var evaluation=document.getElementById("in0").value;
            if (evaluation.length==0){
                document.getElementById("s0").innerHTML="此选项不能为空";
                document.getElementById("s0").style.color='red';
                check=false;
            }else {
                document.getElementById("s0").innerHTML="✔";
                document.getElementById("s0").style.color='green';
                check=true;
            }
            return check;
        }
        function check() {
            var chec=checkage()&&checkphone()&&checkaddress()&&checkcampus()
                &&checkemail()&&checkjobs()&&checkname()&&checkorigin()&&checkfamily()
                &&checkevaluation()
            return chec;
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
                <td><a href="saveresume.do">查看简历</a></td>
                <td><a href="resumestate.do">查看投递状态</a></td>
                <td><a href="companyprofile.do">公司简介</a></td>
                <td><a href="business.do">公司产品展示</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <div id="d4">
            <form method="post" action="addresume.do" onsubmit="return check()">
                姓名：<input id="in1" name="r_name"  onchange="checkname()"><span id="s1"></span><br>
                年龄：<input id="in2"name="r_age" onchange="checkage()"><span id="s2"></span><br>
                籍贯：<input id="in3"name="r_origin"  onchange="checkorigin()"><span id="s3"></span><br>
                民族：<input id="in4"name="r_family"  onchange="checkfamily()"><span id="s4"></span><br>
                手机号码：<input id="in5"name="r_phone"  onchange="checkphone()" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')"
            ><span id="s5"></span><br>
                电子邮箱：<input id="in6"name="r_email"  onchange="checkemail()"><span id="s6"></span><br>
                地址：<input id="in7"name="r_address"  onchange="checkaddress()"><span id="s7"></span><br>
                毕业院校：<input id="in8"name="r_campus"  onchange="checkcampus()"><span id="s8"></span><br>
                工作经历：<input id="in9"name="r_jobs" onchange="checkjobs()"><span id="s9"></span><br>
                个人评价：<input id="in0"name="r_evaluation"  onchange="checkevaluation()"><span id="s0"></span><br>
                <input type="submit" value="创建简历">
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
