<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改员工</title>
</head>
<body>
<form:form modelAttribute="employee" method="post" action="${pageContext.request.contextPath}/emp" >
    <input type="hidden" name="_method" value="put" /> <%-- 定义 Spring 决定 REST 风格的表单项 --%>
    <form:hidden path="id"/>
    email: <form:input path="email" />  <br/>
    gender: <br/>
    男: <form:radiobutton path="gender" value="1" /> <br/>
    女: <form:radiobutton path="gender" value="0" /> <br/>
    dept:
    <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"></form:select>
    <br/>
    <input type="submit" value="修改" />
</form:form>
</body>
</html>
