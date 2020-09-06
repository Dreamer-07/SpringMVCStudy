<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-02
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用 POJO 绑定请求参数</title>
</head>
<body>
<%--
 创建一个表单，设置表单中的表单项的 name 值和 POJO 类中对应的属性名相同
 --%>
<form action="book" method="post">
    书名：<input name="name">
    作者名：<input name="author">
    <hr>
    <%--
    对于需要级联赋值的表单项，其 name 属性值为 级联对象属性的属性
    --%>
    作者-国家：<input name="address.country"> <br/>
    作者-城市地址：<input name="address.city"> <br/>
    <input type="submit" value="添加新图书">
</form>
</body>
</html>
