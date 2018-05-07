<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/22
  Time: 16:32
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#name").blur(function () {
                $.ajax({
                    type:"post",
                    url:"checknames.do",
                    data:"name="+$(this).val(),
                    success:function (date) {
                        if(date==1){
                            $("#sp1").html("用户名已存在")
                            $("#sp1").css("color","red")
                        }else if (date==2){
                            $("#sp1").html("✔")
                            $("#sp1").css("color","green")
                        }
                    }
                })
            })
        })
        function checkn() {
            var check=false;
            var name=document.getElementById("in1").value;
            if (name.length==0){
                document.getElementById("sp1").innerHTML="此选项不能为空";
                document.getElementById("sp1").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkp() {
            var check=false;
            var pass=document.getElementById("in2").value;
            if (pass.length==0){
                document.getElementById("sp2").innerHTML="此选项不能为空";
                document.getElementById("sp2").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function check() {
            var check=checkn()&&checkp()
            return check;
        }
    </script>
    <style>
        #d1{
            height: 600px;
            width:  500px;
            position: fixed;
            left: 1000px;
            top: 200px;
        }
        body {
            background: url('images/bg1.jpg')top center no-repeat;
            background-size:cover;
        }
        .a1{
            font-size: 30px;
        }
        .in1{
            height: 50px;
            width: 300px;
        }
        .in2{
            height: 50px;
            width: 50px;
        }
    </style>
</head>
<body>
<div id="d1">
    <fieldset>
        <legend class="a1">注册界面</legend>
        <form action="adduser.do" method="post" onsubmit="check()">
            <a class="a1"> 账号：</a> <input id="in1" class="in1" id="name" name="name" onchange="checkn()"><span id="sp1"></span><br>
            <a class="a1">密码：</a> <input  id="in2" class="in1" name="upass" maxlength="10" onchange="checkp()"><span id="sp2">//密码不能超过10位数</span><br>
            <input class="in2" type="submit" value="注册">
        </form>
    </fieldset>
</div>
</body>
</html>