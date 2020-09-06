<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<a href="hello">go to success</a> <br/>
<a href="emt/haha">访问作用在类上的@RequestMapping</a> <br/>
<form action="emt/method" method="post">
    <input type="submit" value="method属性的设置 - POST请求"/>
</form> <br/>
<a href="emt/params?username=111&password="> params:需要指定符合规则的请求参数 </a> <br>
<a href="emt/headers"> headers:请求头的参数必须符合规则才可访问 </a>
<hr/>
<h2>RequestMapping-Ant风格的模糊匹配</h2>
<a href="antTest01">01-精准匹配</a>
<a href="emt/pathVariableTest">@PathVariableTest 获取路径上的占位符</a>
</body>
</html>
