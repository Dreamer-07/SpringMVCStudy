<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-06
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工展示</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.9.1.min.js"></script>
<body>
<h1>员工信息</h1>
<table border="1" cellpadding="5px" cellspacing="0px">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birth</th>
        <th>Department</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope.emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"Male":"Female"}</td>
            <td>${emp.birth}</td>
            <td>${emp.department.departmentName}</td>
            <td><a href="${pageContext.request.contextPath}/emp/${emp.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/emp/${emp.id}" class="deleteBtn">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="toAddPage">添加员工</a>
<form id="deleteForm" method="post">
    <input type="hidden" name="_method" value="delete" />
</form>
<script>
    $(function(){
        $(".deleteBtn").click(function () {
            $("#deleteForm").attr("action",this.href); //修改删除表单的 action 属性
            $("#deleteForm").submit(); //提交表单
            return false; //取消默认提交行为
        });
    })
</script>
</body>
</html>
