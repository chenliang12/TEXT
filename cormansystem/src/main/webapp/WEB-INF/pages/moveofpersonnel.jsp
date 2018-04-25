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
</head>
<body>
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
</body>
</html>