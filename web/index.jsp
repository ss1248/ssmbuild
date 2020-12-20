<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>

    <style type="text/css">
      a {
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h3 {
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: deepskyblue;
        border-radius: 4px;
      }
    </style>

  </head>
  <body>
  <h3>
    <a href="${pageContext.request.contextPath}/user/allUser">进入用户页面</a>
  </h3>
  <h4>
    <a href="${pageContext.request.contextPath}/user/register">进入注册界面</a>
    <a href="${pageContext.request.contextPath}/user/login">进入登录界面</a>
    <a href="${pageContext.request.contextPath}/friend/allFriend">好友列表</a>
  </h4>
  </body>
</html>
