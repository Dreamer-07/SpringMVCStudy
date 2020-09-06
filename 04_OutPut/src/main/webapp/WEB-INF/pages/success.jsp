<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-02
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>查看 Map/Model/ModelMap 的数据输出</h2>
pageContext: ${pageScope.msg} <br/>
request:${requestScope.msg} <br/>
session:${sessionScope.msg}- ${sessionScope.age} <br/>
Application:${applicationScope.msg}
<%
System.out.println("成功转发到页面");
%>
</body>
</html>
