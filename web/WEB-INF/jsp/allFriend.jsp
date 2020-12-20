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
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/friend/toAddFriend">增加好友</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/friend/allFriend">显示全部好友</a>
            </div>
            <div class="col-md-8 column">
                <form class="form-inline" action="${pageContext.request.contextPath}/friend/queryFriend" method="post" style="float: right">
                    <span style="color: blue;font-weight: bold">${error}</span>
                    <input type="text" name="queryFriendByName" class="form-controller" placeholder="请输入要查询的好友名称">
                    <input type="text" name="queryFriendById" class="form-controller" placeholder="请输入要查询的好友ID">
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
                <th>好友id</th>
                <th>好友名</th>
                </thead>



                <tbody>
                <c:forEach var="userFriend" items="${list}">
                    <tr>
                        <td>${userFriend.userid}</td>
                        <td>${userFriend.friendId}</td>
                        <td>${userFriend.friendName}6</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/friend/deleteFriend?"userid="${userFriend.userid}+ friendId=${userFriend.friendId}">删除</a>
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