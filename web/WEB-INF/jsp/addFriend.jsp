<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <small>新增好友</small>
                </h1>
            </div>
        </div>

    </div>

    <form action="${pageContext.request.contextPath}/friend/addFriend?userid=${userid}friendId=${friendId}" method="post">
        <div class="form-group">
            <label>要添加好友的id</label>
            <input type="text" name="userid" class="form-control" required>
        </div>
        <div class="form-group">
            <label>添加好友的id</label>
            <input type="text" name="friendId" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit"class="form-control" value="添加">
        </div>
    </form>


</div>

</body>
</html>
