<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/online/css/demo1.css" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>聊天页面实现</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/online/css/demo1.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_2274543_vk3cl1zog2.css">
</head>
<body style="background: #6d929c">
<div style="background:#8eccd9;position: relative;right: -250px;height: 700px;width: 94px;top: 50px">
    <%--头像图片--%>
    <img src="/online/images/head3.jpg" style="height: 70px;width: 70px;margin-left: 12px;margin-top: 30px" id="heading">
    <%--信息按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-xiugaiziliao"
           style="color: black;font-size: 30px;left: 30px;top: 66px;position: relative" id="changeme"
           title="change-message"></i>
    </div>
    <%--联系人按钮--%>
    <div class="icon-box">
        <i class="iconfont icon-lianxiren"
           style="color: black;;font-size: 30px;left: 30px;top: 106px;position: relative" title="chat"></i>
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
        <i class="iconfont icon-guanji1"
           style="color: black;font-size: 30px;left: 30px;top: 399px;position: relative" id="shutdown"
           title="shout-down"></i>
    </div>
    <img src="<%=request.getContextPath()%>/online/images/inbg.gif" style="position: absolute;top: 0px;left: 95px;height: 700px;width: 700px;background-color:#89b9b2">
    <div class="chatbar">
        <%--在线用户--%>
        <div class="chatbar-contacts">
            <div class="contacts-search-box">
                <i class="iconfont icon-icon-"></i>
                <input type="text" class="search-text" placeholder="请输入要搜索的联系人" style="width: 240px">
                <button type="button">搜索</button>
            </div>
            <ul class="chatbar-contacts-uls" id="lists">

            </ul>
        </div>
        <%--聊天框--%>
        <div class="chatbar-messages">
            <%--聊天框头部--%>
            <div class="messages-title">
                <i class="iconfont icon-ren1"></i>
                <h4 id="chatWith">黄小小</h4>
            <!-- 好友验证消息按钮-->
                <button class="fvbu1" id="friendmsg">好友验证消息</button>
            </div>
            <%--聊天框--%>
            <div class="messages-text" id="messages-text">
                <ul class="messages-text-uls">
                    <li class="messages-text-lis">
                    </li>
                </ul>
            </div>
            <%--聊天框消息发送区--%>
            <div class="messages-box">
                <textarea class="messages-content" name="" id="" cols="30" rows="10"></textarea>
                <input class="message-btn" type="button" value="发送" id="message-btn" onclick="sendmessage()">
                <input type="button" onclick="downloadMessage('111111')" value="下载按钮">
                <input type="button" value="查看好友消息">
            </div>
        </div>
        <div id="messagemanage">
            <div>
                <div class="projectList" id="projectList">
                    <div class="item">
                        <div class="times" id="alert_time"></div>
                        <div class="content">
                            <h3 class="title">消息记录</h3>
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
                        <input type="text" id="name" placeholder="您的真实姓名！" value="孟祥博" name="name">
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
<!--                    增加查看好友评价-->
                    <label>
                        <input type="submit" class="button" value="保存信息" style="position: relative;margin-left: 20px">
                        <input type="button" class="button" value="查看好友评价" style="position: relative;margin-left: 120px" id="chev">
                    </label>
            </form>
        </div>
        <div id="friend-search">
            <div style="top: 20px">
                <i class="iconfont icon-icon-" style="font-size: 25px;color: #0073c6;margin-left: 15px"></i>
                <input type="text" id="findArea" class="search-text" placeholder="请输入要搜索的联系人"
                       style="margin-left: 5px;margin-bottom: 10px;height: 35px;margin-top: 15px;" size="25">
                <button type="button" id="find">搜索</button>
                <hr>
<!--                添加好友的样式-->
                <ul class="friends1" id="findfriend">

                   <%-- <li class="friends2" style="margin-top: 22px;"> <i class='iconfont icon-ren1 friends3' title='好友资料'></i>
                        <p class="friends4">黄晓晓<button style="margin-left: 100px">添加好友</button></p><hr></li>
                    <li class="friends2" style="margin-top: 22px;"> <i class='iconfont icon-ren1 friends3' title='好友资料'></i>
                        <p class="friends4">黄晓晓<button style="margin-left: 100px">添加好友</button></p><hr></li>
                    <li class="friends2" style="margin-top: 22px;"> <i class='iconfont icon-ren1 friends3' title='好友资料'></i>
                        <p class="friends4">黄晓晓<button style="margin-left: 100px">添加好友</button></p><hr></li>
--%>

                </ul>
            </div>
        </div>

        <div class="Content-Other">
            <form action="" method="post" class="form-userInfo">
                <p>
                    <img src="/online/images/head3.jpg" alt="加载中..."
                         style="width: 70px;height: 70px;margin-top: 40px;margin-left: 40px;top: 0px;position: relative;">
                    <span style="margin-top: 18px;margin-left: 30px;position: relative;top: -50px;">用户名:</span>
                    <input type="text" name="usrname" id="username1" placeholder="好友的用户名"
                           style="position: relative;margin-left: 136px;top: -40px;width: 200px" disabled>
                    <label style="margin-top: 0px;">
                        <span>姓&emsp;&emsp;名：</span>
                        <input type="text" name="name" id="name1" placeholder="好友的真实姓名！" disabled>
                    </label>
                    <label>
                        <span>生&emsp;&emsp;日：</span>
                        <input type="text" name="birthday" id="birthday1" placeholder="填写您的出生日期！" disabled>
                    </label>
                    <label>
                        <span>电子邮件：</span>
                        <input type="email" name="email"id="email1" placeholder="@.com" disabled>
                    </label>
                    <label>
                        <span>手机号码：</span>
                        <input type="text" name="tel" id="tel1" placeholder="好友的电话号码!" disabled>
                    </label>
                    <label>
<!--好友的介绍与评价-->
                        <span>个人介绍：</span>
                        <textarea id="evaluate" name="evaluate" placeholder="好友介绍" disabled></textarea>
                    </label>
                    <label>
                        <input type="button" class="button" value="查看好友评价" style="position: relative;margin-left: 140px" id="cfe">
                    </label>
            </form>
        </div>

<!--好友评价界面-->
        <div class="evaluate1">
            <ul class="friends1">
                <li class="friends2"><p>这个人很懒，什么都没留下。。。</p></li>
                <li class="friends2"><p>这个人很懒，什么都没留下。。。</p></li>
                <li class="friends2"><p>这个人很懒，什么都没留下。。。</p></li>
                <li class="friends2"><p>这个人很懒，什么都没留下。。。</p></li>
            </ul>
        </div>
    </div>
<!--好友验证界面-->
    <div class="fri-ver">
        <ul class="friends3">


<%--            <li class="friends2"><p>您收到xxx的好友请求</p><button class="fvbu">接受</button><button class="fvbu">拒绝</button></li>--%>
<%--            <li class="friends2"><p>您收到xxx的好友请求</p><button class="fvbu">接受</button><button class="fvbu">拒绝</button></li>--%>
<%--            <li class="friends2"><p>您收到xxx的好友请求</p><button class="fvbu">接受</button><button class="fvbu">拒绝</button></li>--%>


        </ul>
    </div>
        <div class="fevaluate">
            <textarea class="evarea"></textarea>
            <button class="evbt">添加好友评价</button>
        </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/online/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/online/js/demo.js"></script>
</body>
</html>

