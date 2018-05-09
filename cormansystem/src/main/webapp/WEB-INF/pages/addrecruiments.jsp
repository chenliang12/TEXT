<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/25
  Time: 9:23
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
    <script>
        function checkjob() {
            var check=false;
            var job=document.getElementById("in1").value;
            if (job.length==0){
                document.getElementById("s1").innerHTML="此选项不能为空";
                document.getElementById("s1").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkdemend() {
            var check=false;
            var demend=document.getElementById("in2").value;
            if (demend.length==0){
                document.getElementById("s2").innerHTML="此选项不能为空";
                document.getElementById("s2").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checktreatment() {
            var check=false;
            var treatment=document.getElementById("in3").value;
            if (treatment.length==0){
                document.getElementById("s3").innerHTML="此选项不能为空";
                document.getElementById("s3").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkworkplace() {
            var check=false;
            var workplace=document.getElementById("in4").value;
            if (workplace.length==0){
                document.getElementById("s4").innerHTML="此选项不能为空";
                document.getElementById("s4").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function check() {
            var check=checkjob()&&checkdemend()&&checktreatment()&&checkworkplace()
            return check;
        }
    </script>
    <style>
       .p1{
           color: dimgray;
           font-size: 15px;
       }
        .in1{
            height: 200px;
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
                <td><a href="adsavedissents.do">查看奖惩异议信息</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <form method="post" action="addrecruiment.do" ONSUBMIT="return check()">
            <table>
                <tr>
                    <td>职位：</td>
                    <td><input id="in1" name="r_job" maxlength="10" onchange="checkjob()"></td>
                    <td><span id="s1" class="p1">//最多只能输入10个汉字</span></td>
                </tr>
                <tr>
                    <td>工作要求：</td>
                    <td><textarea   rows="5" cols="40" id="in2" class="in1" name="r_demand" maxlength="100" onchange="checkdemend()"></textarea></td>
                    <td><span id="s2" class="p1">//最多只能输入100个汉字</span></td>
                </tr>
                <tr>
                    <td>待遇：</td>
                    <td><textarea   rows="5" cols="40" id="in3" class="in1" name="r_treatment" maxlength="100" onchange="checktreatment()"></textarea></td>
                    <td><span id="s3" class="p1">//最多只能输入100个汉字</span></td>
                </tr>
                <tr>
                    <td>工作地点：</td>
                    <td><input id="in4" name="r_workplace" maxlength="20" onchange="checkworkplace()"></td>
                    <td><span id="s4" class="p1">//最多只能输入20个汉字</span></td>
                </tr>
                <tr>
                    <td>操作：</td>
                    <td>
                        <input type="submit" value="生成招聘信息">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>