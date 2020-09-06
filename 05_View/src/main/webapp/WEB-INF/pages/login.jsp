<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-05
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><fmt:message key="WelcomeInfo"/></h2>
<form method="post">
    <fmt:message key="Username"/>：<input />
    <fmt:message key="Password"/>：<input />
    <input type="submit" value="<fmt:message key="LoginBtn"/>">
</form>
</body>
</html>
