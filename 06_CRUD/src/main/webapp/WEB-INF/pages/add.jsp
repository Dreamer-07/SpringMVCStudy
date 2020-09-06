<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<%--
使用 SpringMVC 表单标签
    - 将模型数据中的属性与 HTML 中的表单元素相互绑定，
      以实现表单项的回显和快速编辑
    - 有两种方式实现将 表单 和 属性的模型数据对象 相互绑定
        1. 在 request 域中存放一个 key 值为 command 的 数据对象
        2. 使用 modelAttribute 属性指定 key 值
--%>
<form:form modelAttribute="employee" method="post" action="${pageContext.request.contextPath}/emp">
    <%--
        path 就是 HTML - input 中的 name 属性值
            (主要作用)
             1. 作为表单项提交时的 name 属性值
             2. 绑定 模型数据对象 的 属性，可以自动回显对应的属性值
    --%>
    lastName: <form:input path="lastName"/>  <br/>
    email: <form:input path="email" />  <br/>
    gender: <br/>
    男: <form:radiobutton path="gender" value="1" /> <br/>
    女: <form:radiobutton path="gender" value="0" /> <br/>
    dept:
    <%--
    items=""：指定要遍历的集合
    itemLabel：在这里指 option 标签体中的内容，与 items 集合遍历出来的数据对象中的属性相绑定
    itemValue：在这里指 option 标签的 value 属性值，与 items 集合遍历出来的数据对象中的属性相绑定
    --%>
    <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id">
    </form:select>
    <br/>
    <input type="submit" value="提交" />
</form:form>


</body>
</html>
