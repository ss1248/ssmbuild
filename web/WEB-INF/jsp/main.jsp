<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/online/css/demo.css" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>聊天主页面</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/online/css/demo.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_2274543_vk3cl1zog2.css">
</head>
<body style="color: #6d929c">
<div style="background:#8eccd9;position: absolute;right: 1233px;height: 700px;width: 94px;top: 50px">
    <%--头像图片--%>
    <img src="${pageContext.request.contextPath}/online/images/head3.jpg" style="height: 70px;width: 70px;margin-left: 12px;margin-top: 30px" id="heading">
    <%--信息按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-xiugaiziliao"
           style="color: black;font-size: 30px;left: 30px;top: 66px;position: relative" id="changeme"
           title="change-message"></i>
    </div>
    <%--联系人按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-lianxiren"
           style="color: black;font-size: 30px;left: 30px;top: 106px;position: relative" title="chat"></i>
    </div>
    <%--消息按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-xiaoxi"
           style="font-size: 30px;left: 30px;top: 146px;position: relative;color: black" id="xiaoxi"
           title="message"></i>
    </div>
    <%--添加按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-tianjia"
           style="color: black;font-size: 30px;left: 30px;top: 176px;position: relative" id="add"
           title="add-friends"></i>
    </div>
    <%--退出按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-close"
           style="color: black;font-size: 30px;left: 30px;top: 399px;position: relative" id="shutdown"
           title="add-friends"></i>
    </div>

</div>
<img src="<%=request.getContextPath()%>/online/images/inbg.gif" style="position: relative;top: 50px;left: 474px;height: 700px;width: 700px;background-color:#89b9b2">
<div class="chatbar">
    <div class="chatbar-box">
        <%--在线用户--%>
        <div class="chatbar-contacts">
            <div class="contacts-search-box">
                <i class="iconfont icon-icon-"></i>
                <input type="text" class="search-text" placeholder="请输入要搜索的联系人">
            </div>
            <ul class="chatbar-contacts-uls" id="lists">
            </ul>
        </div>
        <%--聊天框--%>
        <div class="chatbar-messages">
            <%--聊天框头部--%>
            <div class="messages-title" >
                <i class="iconfont icon-ren1" ></i>
                <h4 id="chatWith">黄小小</h4>
            </div>
            <%--聊天框消息发送区--%>
            <div class="messages-text" id="messages-text">
                <ul class="messages-text-uls">
                    <li class="messages-text-lis">
                    </li>
                </ul>
            </div>
            <%--聊天框消息发送区--%>
            <div class="messages-box">
                <textarea class="messages-content" name="" id="send" cols="30" rows="10"></textarea>
                <input class="message-btn" type="button" value="发送" id="message-btn" onclick="sendmessage()">
            </div>
        </div>

        <div id="messagemanage">
            <div>
                <div class="projectList" id="projectList">
                    <div class="item">
                        <div class="times" id="alert_time"></div>
                        <div class="content">
                            <h3 class="title">标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题</h3>
                            <div class="textcontent">
                                文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容
                            </div>
                            <div class="detail"><span class="lookdetail">查看详情</span></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--个人信息修改，完成数据库前后端交汇--%>
        <div class="Content-Main">
            <form action="${pageContext.request.contextPath}/user/remain" method="post" class="form-userInfo">
                <p>
                    <img src="/online/images/head3.jpg"
                         style="width: 70px;height: 70px;margin-top: 40px;margin-left: 40px;top: 0px;position: relative;">
                    <span style="margin-top: 18px;margin-left: 30px;position: relative;top: -50px;">用户名:</span>
                    <input type="text" name="username" id="username" placeholder="你登录的用户名"
                           style="position: relative;margin-left: 136px;top: -40px;width: 200px">
                    <label style="margin-top: 0px;">
                        <span>姓&emsp;&emsp;名：</span>
                        <input type="text" name="name" id="name" placeholder="您的真实姓名！">
                    </label>
                    <label>
                        <span>生&emsp;&emsp;日：</span>
                        <input type="text" name="birthday" id="birthday" placeholder="填写您的出生日期！">
                    </label>
                    <label>
                        <span>电子邮件：</span>
                        <input type="email" name="email" id="email" placeholder="@.com">
                    </label>
                    <label>
                        <span>手机号码：</span>
                        <input type="text" name="tel" id="tel" placeholder="输入您的电话号码!">
                    </label>
                    <label>
                        <span>个人介绍：</span>
                        <textarea id="message" name="instructions" placeholder="输入您的个人介绍！"></textarea>
                    </label>
                    <label>
                        <input type="submit" class="button" value="保存信息" style="position: relative;margin-left: 140px">
                    </label>
            </form>
        </div>

        <div id="friend-search">
            <div style="top: 20px">
                <i class="iconfont" style="font-size: 25px;color: #0073c6;margin-left: 15px">&#xe651;</i>
                <input type="text" id="findArea" class="search-text" placeholder="请输入要搜索的联系人"
                       style="margin-left: 5px;margin-bottom: 10px;height: 35px;margin-top: 15px;" size="25">
                <button id="find" type="button">搜索</button>
                <hr>
            </div>
        </div>


        <%--好友信息：未设置返回值--%>
        <div class="Content-Other">
            <form action="" method="post" class="form-userInfo">
                <p>
                    <img src="/online/images/head3.jpg" alt="加载中......"
                         style="width: 70px;height: 70px;margin-top: 40px;margin-left: 40px;top: 0px;position: relative;">
                    <span style="margin-top: 18px;margin-left: 30px;position: relative;top: -50px;">用户名:</span>
                    <input type="text" name="username" id="username1" placeholder="好友的用户名"
                           style="position: relative;margin-left: 136px;top: -40px;width: 200px" readonly>
                    <label style="margin-top: 0px;">
                        <span>姓&emsp;&emsp;名：</span>
                        <input type="text" name="name" id="name1" placeholder="好友的真实姓名！" readonly>
                    </label>
                    <label>
                        <span>生&emsp;&emsp;日：</span>
                        <input type="text" name="birthday" id="birthday1" placeholder="填写您的出生日期！" readonly>
                    </label>
                    <label>
                        <span>电子邮件：</span>
                        <input type="email" name="email"id="email1" placeholder="@.com" readonly>
                    </label>
                    <label>
                        <span>手机号码：</span>
                        <input type="text" name="tel" id="tel1" placeholder="好友的电话号码!" readonly>
                    </label>
                    <label>
                        <span>好友评价：</span>
                        <textarea id="evaluate" name="friendView" placeholder="好友评价！"></textarea>
                    </label>
                    <label>
                        <input type="button" class="button" value="修改好友评价" onclick="remainFriendView()" style="position: relative;margin-left: 140px">
                    </label>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="<%=request.getContextPath()%>/online/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/online/js/demo.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/online/js/ajax.js"></script>
</div>
</body>
</html>

