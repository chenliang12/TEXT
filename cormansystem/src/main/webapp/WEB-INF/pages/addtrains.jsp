<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        function check() {
            var check=checkaddress()&&checkcontent()&&checkdate()&&checkdepname()&&checktitle()
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
        <form method="post" action="addtrain.do" onsubmit="return check()">
            <table >
                <tr>
                    <td>培训主题</td>
                    <td><input id="in1" name="t_title" onchange="checktitle()"></td>
                    <td><span id="s1"></span></td>
                </tr>
                <tr>
                    <td>培训内容</td>
                    <td><input id="in2" name="t_content" onchange="checkcontent()"></td>
                    <td><span id="s2"></span></td>
                </tr>
                <tr>
                    <td>培训地点</td>
                    <td><input id="in3" name="t_address" onchange="checkaddress()"></td>
                    <td><span id="s3"></span></td>
                </tr>
                <tr>
                    <td>培训时间</td>
                    <td><input id="in4" name="t_date" onchange="checkdate()"></td>
                    <td><span id="s4"></span></td>
                </tr>
                <tr>
                    <td>培训部门</td>
                    <td> <select id="in5" name="depname" onchange="checkdepname()">
                        <option value="0">请选择</option>
                        <c:forEach items="${sessionScope.departments}" var="depart">
                            <option value="${depart.d_depat}">${depart.d_depat}</option>
                        </c:forEach>
                    </select><br/></td>
                    <td><span id="s5"></span></td>
                </tr>
            </table>
            <input type="submit" value="创建培训">
        </form>
    </div>
</div>
</body>
</html>