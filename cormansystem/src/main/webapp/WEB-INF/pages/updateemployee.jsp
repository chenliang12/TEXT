<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/23
  Time: 19:05
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
        function checkage() {
            var check=false;
            var age=document.getElementById("in1").value;
            if (age.length==0){
                document.getElementById("s1").innerHTML="此选项不能为空";
                document.getElementById("s1").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkphone() {
            var check=false;
            var phone=document.getElementById("in2").value;
            if (phone.length==0){
                document.getElementById("s2").innerHTML="此选项不能为空";
                document.getElementById("s2").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function check() {
            var check=checkphone()&&checkage()
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
    </style>
</head>
<body>
<div id="d1">
    <div id="d2" align="center">
        <table>
            <tr>
                <td><a href="saveemploy.do">查看个人信息</a></td>
                <td><a href="saveemps.do">查看其他员工信息</a></td>
                <td><a href="emsavetrain.do">查看培训信息</a></td>
                <td><a href="emsavereandpun.do">查看个人奖惩记录</a></td>
                <td><a href="emsavewages.do">查看个人薪资记录</a></td>
                <td><a href="attendance.do">签到</a></td>
                <td><a href="emsavedissent.do">查看奖惩异议处理进度</a></td>
            </tr>
        </table>
    </div>
    <div id="d3">
        <form method="post" action="updateemployee.do" onsubmit="return check()">
            <table>
                <tr>
                    <td>姓名</td>
                    <td>${sessionScope.employee.e_name}</td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input id="in1" name="e_age" value="${sessionScope.employee.e_age}" onchange="checkage()"></td>
                    <td><span id="s1"></span></td>
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
                    <td><input id="in2" name="e_phone" value="${sessionScope.employee.e_phone}" onchange="checkphone()"></td>
                    <td><span id="s2"></span></td>
                </tr>
                <tr><!--date日期转化年月日-->
                    <td>入职时间</td>
                    <td>${sessionScope.employee.date}</td>
                </tr>
                <tr>
                    <td>状态</td>
                    <td>${sessionScope.employee.e_state}</td>
                </tr>
                <tr>
                    <td>离职原因</td>
                    <td>${sessionScope.employee.e_reason}</td>
                </tr>
            </table>
            <input type="submit" value="确认修改">
        </form>
    </div>
</div>
</body>
</html>