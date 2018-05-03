<%--
  Created by IntelliJ IDEA.
  User: one
  Date: 2018/4/24
  Time: 12:40
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
        function checktitle() {
            var check=false;
            var title=document.getElementById("in1").value;
            if (title.length==0){
                document.getElementById("s1").innerHTML="此选项不能为空";
                document.getElementById("s1").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkcontent() {
            var check=false;
            var content=document.getElementById("in2").value;
            if (content.length==0){
                document.getElementById("s2").innerHTML="此选项不能为空";
                document.getElementById("s2").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkaddress() {
            var check=false;
            var address=document.getElementById("in3").value;
            if (address.length==0){
                document.getElementById("s3").innerHTML="此选项不能为空";
                document.getElementById("s3").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkdate() {
            var check=false;
            var date=document.getElementById("in4").value;
            if (date.length==0){
                document.getElementById("s4").innerHTML="此选项不能为空";
                document.getElementById("s4").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
        function checkdepname() {
            var check=false;
            var depname=document.getElementById("in5").value;
            if (depname.length==0){
                document.getElementById("s5").innerHTML="此选项不能为空";
                document.getElementById("s5").style.color='red';
                check=false;
            }else {
                check=true;
            }
            return check;
        }
    </script>
</head>
<body>
<form method="post" action="addtrain.do">
    <table >
        <tr>
            <td>培训主题</td>
            <td><input id="in1" name="t_title"></td>
            <td><span id="s1"></span></td>
        </tr>
        <tr>
            <td>培训内容</td>
            <td><input id="in2" name="t_content"></td>
            <td><span id="s2"></span></td>
        </tr>
        <tr>
            <td>培训地点</td>
            <td><input id="in3" name="t_address"></td>
            <td><span id="s3"></span></td>
        </tr>
        <tr>
            <td>培训时间</td>
            <td><input id="in4" name="t_date"></td>
            <td><span id="s4"></span></td>
        </tr>
        <tr>
            <td>培训部门</td>
            <td><input id="in5" name="depname"></td>
            <td><span id="s5"></span></td>
        </tr>
    </table>
    <input type="submit" value="创建培训">
</form>
</body>
</html>