<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="ajax/empAll" id="ajaxEmpAll">获取所有员工的信息</a>
<div id="empList"></div>
<script src="/script/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    // 点击 a 标签发送 ajax 请求
    $("#ajaxEmpAll").click(function (){
        //发送 ajax 请求
        $.ajax({
            url:"ajax/empAll",
            type:"GET",
            //获取请求返回的 json 数据
            success:function (data){
                $.each(data,function (){
                    var empInfo = data.lastName + " --> " + data.email;
                    $("#empList").append(empInfo + "<br/>")
                })
            }
        })
        //取消默认行为
        return false;
    })
</script>
</body>
</html>
