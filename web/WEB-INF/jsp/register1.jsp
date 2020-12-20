<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎注册</title>

</head>
<body>

<div style="width: 100%">
    <hr>
    <div style="width: 50%">
        <form action="${pageContext.request.contextPath}/user/testRegister" method="post">
            <div class="form-group">
                <label>输入用户名</label>
                <input type="text" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label>输入用户密码</label>
                <input type="text" name="password" class="form-control"required>
            </div>
            <div class="form-group">
                <label>再次确定密码</label>
                <input type="text" name="password2" class="form-control" required>
            </div>
            <input type="submit" value="提交">
            <input type="reset" value="重置"><br>
            <span style="color: blue;font-weight: bold">${error}</span>
        </form>
    </div>
</div>
</body>
</html>
