<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改用户</small>
                </h1>
            </div>
        </div>

    </div>

    <form action="${pageContext.request.contextPath}/user/updateUser" method="post">
        <input type="hidden" name="id" value="${QUser.id}">
        <div class="form-group">
            <label>用户名称</label>
            <input type="text" name="username" class="form-control" value="${QUser.username}" required>
        </div>
        <div class="form-group">
            <label>用户密码</label>
            <input type="text" name="password" class="form-control" value="${QUser.password}" required>
        </div>
        <div class="form-group">
            <label>名字</label>
            <input type="text" name="name" class="form-control" value="${QUser.name}">
        </div>
        <div class="form-group">
            <label>生日</label>
            <input type="text" name="birthday" class="form-control" value="${QUser.birthday}">
        </div>
        <div class="form-group">
            <label>电话</label>
            <input type="text" name="tel" class="form-control" value="${QUser.tel}">
        </div>
        <div class="form-group">
            <label>介绍</label>
            <input type="text" name="instructions" class="form-control" value="${QUser.instructions}">
        </div>
        <div class="form-group">
            <label>邮箱</label>
            <input type="text" name="email" class="form-control" value="${QUser.email}">
        </div>
        <div class="form-group">
            <input type="submit"class="form-control" value="修改">
        </div>
    </form>


</div>
</body>
</html>
