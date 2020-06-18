<%--
  Created by IntelliJ IDEA.
  User: 88632
  Date: 2020/6/9
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/ajax.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    type:"post",
                    url:"getErrorData",
                    success:function (data) {
                        console.log(data)
                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="#" id="dw" class="easyui-linkbutton" onclick="exportExcel('downloadErrorExcel','errData')">下载模板</a>
<input type="button" value="获取错误数据" id="btn">
</body>
</html>
