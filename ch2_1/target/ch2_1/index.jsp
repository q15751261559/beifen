<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        function testJson(){
            console.log(123)
            var pname=$("#pname").val();
            var password=$("#password").val();
            var page=$("#page").val();
            $.ajax({
                url:"/testJson",
                type:"post",
                data:JSON.stringify({pname:pname, password:password,page:page}),
                contentType:"application/json;charset=utf-8",
                dateType:"json",
                success:function (data){
                    if (data !=null)
                    {
                        // alert("输入的用户名："+data.pname+",密码："+data.password+",年龄:"+data.page)
                        // for (var i=0;i<data.length;i++)
                        // {
                        //     alert(data[i].pname);
                        // }
                        // for (var i=0;i<data.length;i++) {
                        //     alert(data[i].pname);
                        // }
                        alert(data.pname)
                    }
                }
            });
        }
    </script>
</head>
<body>
<form action="">
    用户名：<input type="text" name="pname" id="pname"><br>
    密码：<input type="password" name="password" id="password"><br>
    年龄：<input type="text" name="page" id="page"><br>
    <input type="button" value="测试" onclick="testJson()">
</form>
</body>
</html>