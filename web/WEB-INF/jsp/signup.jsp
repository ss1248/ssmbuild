<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="jquery.min.js"></script>
    <script src="jquery-2.1.4.min.js"></script>
    <link href="signin.css" rel="stylesheet">
    <style>
        .must{
            color: red;
        }
    </style>
</head>
<body class="text-center" style="background-color: lightyellow">

<main class="form-signin">
    <form id="signupform" action="" method="post" onsubmit="return checkLoginForm()">

        <h1 class="h3 mb-3 fw-normal">注&nbsp;&nbsp;&nbsp;册</h1>
        <label for="userid" style="float: left">用户名<span class="must">*</span></label>
        <input type="text" id="userid" class="form-control" placeholder="请输入用户名 "  autofocus>

        <label for="password" style="float: left">密&nbsp;&nbsp;&nbsp;码<span class="must">*</span></label>
        <input type="password" id="password" class="form-control" placeholder="请输入密码 长度至少为6个字符">

        <label for="password" style="float: left">确认密码<span class="must">*</span></label>
        <input type="password" id="password2" class="form-control" placeholder="请重复输入密码">




        <input class="w-75 btn btn-lg btn-primary" type="button" value="注册" onclick="resgister()">
    </form>
</main>

</body>
</html>