<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>REST风格的增删改查</h2>
<a href="book/1">获取图书信息</a> <br/>
<%--
 完成 Spring 对于 REST 风格的支持
    对于需要发送 DELETE 和 PUT 请求方式的请求，完成如下步骤
        1. 创建一个表单，该表单的提交方式为 POST
        2. 创建一个表单项，name 属性值为 _method
        3. _method 表单项的 value 属性值就是需要转换的请求方式
 --%>
<form action="book/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除图书信息">
</form>
<br/>

<form action="book/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="更新图书信息">
</form>
<br/>

<form action="book" method="post">
    <input type="submit" value="添加图书信息">
</form>

</body>
</html>
