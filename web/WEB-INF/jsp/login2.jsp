<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/online/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/online/js/jquery-2.1.4.min.js"></script>
    <link href="${pageContext.request.contextPath}/online/css/signin.css" rel="stylesheet">
</head>
<body class="text-center" style="background-color: lightyellow">

<main class="form-signin" style="margin-top: 150px">
    <form action="${pageContext.request.contextPath}/user/testLogin" method="post" >
        <!--src是放那个头像的地方。-->
        <img class="mb-4" src="/online/images/1.jpg" alt="无法显示图片" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">登&nbsp;&nbsp;&nbsp;录</h1>
        <label class="visually-hidden">用户名</label>
        <input type="text" name="username" class="form-control" required>
        <label class="visually-hidden">密码</label>
        <input type="text" name="password" class="form-control" required>

        <br>
        <input class="w-75 btn btn-lg btn-primary" type="submit" value="登录">
    </form>
        <br>
    <form id="register" action="${pageContext.request.contextPath}/user/register">
        <input class="w-75 btn btn-lg btn-primary" type="submit" value="注册" >
    </form>

</main>
<%--<script>--%>
<%--    function resgister() {--%>
<%--        $("#register").submit();--%>
<%--        //window.location.href="register";--%>
<%--    }--%>
<%--    function checkLoginForm() {--%>
<%--        var username = $('#userid').val();--%>
<%--        var password = $('#password').val();--%>


<%--        if (isNull(username) && isNull(password)) {--%>
<%--            $('#submit').attr('value', '还未输入账号密码').css('background', 'lightsalmon');--%>
<%--            return false;--%>
<%--        }--%>
<%--        if (isNull(username)) {--%>
<%--            $('#submit').attr('value', '请输入账号!!!').css('background', 'lightsalmon');--%>
<%--            return false;--%>
<%--        }--%>
<%--        if (isNull(password)) {--%>
<%--            $('#submit').attr('value', '请输入密码!!!').css('background', 'lightsalmon');--%>
<%--            return false;--%>
<%--        }--%>
<%--            //if(username != 'Amaya' || password != '123456'){--%>
<%--            //	$('#submit').attr('value','账号或密码错误!!!').css('background','red');--%>
<%--            //	return false;--%>
<%--        //}--%>
<%--        else {--%>
<%--            $('#submit').attr('value', '登陆中~');--%>
<%--            return true;--%>
<%--        }--%>

<%--        function isNull(input) {--%>
<%--            if (input == null || input == '' || input == undefined) {--%>
<%--                return true;--%>
<%--            } else {--%>
<%--                return false;--%>
<%--            }--%>
<%--        }--%>
<%--    }--%>
<%-- </script>--%>
</body>
</html>