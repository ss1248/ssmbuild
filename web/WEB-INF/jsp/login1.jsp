<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>

</head>
<body>
<div style="width: 100%">
    <div style="width: 50%">
        <form action="${pageContext.request.contextPath}/user/testLogin" method="post">
            <div class="form-group">
                <label>用户名</label>
                <input type="text" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label>用户密码</label>
                <input type="text" name="password" class="form-control" required>
            </div>
            <input type="submit" value="登录"><br>
            <span style="color: blue;font-weight: bold">${error}</span>
            <span style="color: yellow;font-weight: bold">${secessful}</span>
        </form>
    </div>
</div>

</body>
</html>
