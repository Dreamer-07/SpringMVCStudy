<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- @RequestBody使用1： 接受请求体数据 --%>
<form method="post" action="ajax/addEmp">
    <input type="text" name="username" value="EMT" /> <br/>
    <input type="text" name="password" value="123456" /> <br/>
    <input type="submit" value="添加数据"> <br/>
</form>
<%-- @RequestBody使用2： 接受 JSON 数据 --%>
<a href="#"> 发送 JSON 数据添加员工 </a>
<script src="script/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    //定义一个 JS 对象
    var emp = {
        lastName:"EMT!",
        email:"123@123.com",
        gender:0
    }

    $("a:first").click(function (){
        //发送 Ajax 请求
        $.ajax({
            url:"ajax/addEmpBean",
            type:"POST",
            contentType:"application/json", //指定发送数据类型为 JSON
            data:JSON.stringify(emp),//将 JS 对象转换为 JSON 字符串后作为数据发送
            success:function (data){
                alert(data);
            }
        })
        return false;
    });
</script>
</body>
</html>
