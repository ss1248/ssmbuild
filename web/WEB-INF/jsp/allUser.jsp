<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户展示</title>

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
                    <small>用户列表 —— 显示所有用户</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toAddUser">新增用户</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/allUser">显示全部用户</a>
            </div>
            <div class="col-md-8 column">
                <form class="form-inline" action="${pageContext.request.contextPath}/user/queryUser" method="post" style="float: right">
                    <span style="color: blue;font-weight: bold">${error}</span>
                    <input type="text" name="queryUserName" class="form-controller" placeholder="请输入要查询的用户名">
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>



    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table-hover table table-striped">
                <thead>
                <th>用户id</th>
                <th>用户名</th>
                <th>密码</th>
                <th>操作</th>
                </thead>



                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user/toUpdate?id=${user.id}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/user/deleteUser/${user.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>