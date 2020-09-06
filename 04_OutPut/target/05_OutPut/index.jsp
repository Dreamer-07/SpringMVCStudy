<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-02
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据输出</title>
</head>
<body>
<h2>方式1</h2>
<a href="hello">hello world</a> <br/>
<a href="map">数据输出-Map</a> <br/>
<a href="model">数据输出-Model</a> <br/>
<a href="modelMap">数据输出-modelMap</a>

<h2>方式2 - 返回 ModelAndView 类型的数据</h2>
<a href="modelAndView">数据输出 - 返回 ModelAndView</a>

<h2>@ModelAttribute 的使用</h2>
<form action="book" method="post">
    <input type="hidden" name="id" value="1">
    书名：《胰脏物语》 <br/>
    作者：<input type="text" name="author"> <br/>
    价格：<input type="text" name="price"> <br/>
    <input type="submit" value="修改图书信息">
</form>
</body>
</html>
