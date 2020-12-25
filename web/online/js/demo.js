var toName; //消息接受者账号
var userName;   //发送消息者的账号
// $(".chatbar-contacts-uls").html(html);
//点击按钮下拉
$(".icon-lianxiren").bind('click', function () {
    if ($(".chatbar").is(":visible")) {
        $(".chatbar").slideUp();
        $(".icon-box").removeClass('shadow');
    } else {
        $(".chatbar").slideDown();
        $(".icon-box").addClass('' + '' + 'shadow');
    }
    $.ajax({
        url:'/friend/allFriend',
        data:{'currentUser':userName},
        success:function (data){
            console.log(data);
            $("#friendList").html("");
            for(var i=0;i<data.length;i++){
                $("#friendList").append("<li><i class='iconfont icon-ren1' title='好友资料'></i><p>" +
                    data[i].friendName + "</p><i onclick='deletefriend("+data[i].friendName+")' class='iconfont icon-shanchuhaoyou1' id='deletfriend' title='删除好友'style='margin-left: 210px;'></i>");
            }
        }
    })
});

//点击删除好友事假，删除该与用户的好友关系
function deletefriend(name){
    $.ajax({
        url:'/friend/deleteFriend',
        data:{'userName':name,'friendName':userName},
        success:function (data){
            if(data=='OK')
                console.log("删除好友成功");
        },
        error:function (){
            console.log("删除好友失败");
        }


    })
}



//点击头像事件
function showChat(name){
    toName=name;
    $('.messages-title h4').text(toName);
    $(".messages-text").html("");
    //sessionStorage
    var chatData=sessionStorage.getItem(toName);
    if(chatData != null){
        //将聊天记录渲染到聊天区
        $(".messages-text").html(chatData)
    }
}

//时间封装
function time(type) {
    type = type || 'hh:mm'
    var timer = new Date();
    var year = timer.getFullYear();
    var month = timer.getMonth() + 1;
    var date = timer.getDate();
    var hour = timer.getHours();
    var min = timer.getMinutes();
    if (type == 'hh:mm') {
        hour = hour < 10 ? ('0' + hour) : hour;
        min = min < 10 ? ('0' + min) : min;
    }
    var time = year + "/" + month + "/" + date + "  " + hour + ":" + min;
    return time;
}



//添加好友搜索功能
//完成
$("#find").click(function (){
    var name =$("#findArea").val();
    $.ajax({
        type:'post',
        // async:false,
        url:"/friend/queryUser",//后端取值接口，给搜索账号（name），返回搜索用户信息
        data:{'friendName':name},
        success:function (data){
            console.log(data);
            if (data[0] == null) {
                alert('用户不存在');
            }
            else {
                // 将所有符合搜索条件的用户显示
                $(".friends1").html("");
                for (var i = 0; i < data.length; i++) {
                    $(".friends1").append("<li class=\"friends2\" style=\"margin-top: 22px;\">"+ "<i class='iconfont icon-ren1 friends3' title='好友资料'></i>"+
                    "<p class=\"friends4\">"+data[i].username+"<button id='addd' style=\"margin-left: 100px\"" +
                        "onclick=\"addFriend(" + "'" + data[i].username + "'" + ")\">添加好友</button></p><hr></li>");
                }
            }
        },
        error(error){
            console.log(error);
        }
    })
})

//点击添加好友按钮,获得显示用户的账号name,将好友消息请求消息添加到数据库中
//完成
function addFriend(toName){
    if(toName==userName)
    {
        alert("不能添加自己为好友！");
    }
    else{
        $.ajax({
            type: 'POST',
            url: '/msg/addMsg',
            // data: data,
            data:{"fromUserName":userName,"toUserName":toName},
            success: function () {

            }
        });
        alert("已发送!");
    }

}


//点击好友列表消息历史记录按钮，显示消息记录
$("#").click(function (){
    $.ajax({
        url:'',//前端传：发送账号，接受账号，消息内容，存入数据库
        data:{'fromUserName':userName,"toUseName":toName},
        success:function (data){
            console.log();
        },
        error:function (error){
            console.log(error);
        }
    })
})


//下载好友
$("#send").click(function (){
    var msg = $("#send").val();
    $.ajax({
        url:'',//前端传：发送账号，接受账号，消息内容，存入数据库
        data:{'fromUserName':userName,"toUseName":name,'msg':msg},
        success:function (data){
            console.log();
        },
        error:function (error){
            console.log(error);
        }
    })
})

//点击好友
var count = 0;
var div = document.getElementById("messagemanage");
var div1 = document.getElementById("friend-search");
var bbb = document.getElementById("xiaoxi");
var ccc = document.getElementById("add")
bbb.onclick = function () {
    count++;
    if (count % 2 === 1)
        div.style.visibility = "visible";
    if (count % 2 === 0)
        div.style.visibility = "hidden";
}

ccc.onclick = function () {
    count++;
    if (count % 2 === 1)
        div1.style.visibility = "visible";
    if (count % 2 === 0)
        div1.style.visibility = "hidden";
}

document.getElementById("alert_time").innerText = time()
//好友消息，验证消息等下拉窗口
$("#heading").hover(function () {
    $(".Content-Main").slideToggle();
});
$("#chev").click(function () {
    $(".evaluate1").slideToggle();
});
$("#cfe").click(function () {
    $(".fevaluate").slideToggle();
});

//点击好友验证消息按钮
$(".fvbu1").click(function () {
    $(".fri-ver").slideToggle();
    getNotice(userName);
});


//同意添加好友
function addAgree(fromUserName) {
    console.log("agree");
    $.ajax({
        type: 'POST',
        url: '/friend/addFriend1',
        data:{'sendUserName':fromUserName,'toUserName':userName},
        // data: data,
        success: function () {
           addRefuse(fromUserName);
        }
    });
    //作用是完成添加好友后删除通知
}

function addRefuse(fromUserName) {
    //delete notice
    $.ajax({
        type: 'POST',
        url: '/msg/deleteMsg',
        data:{'fromUserName':fromUserName},
        // data: data,
        success: function () {
            alert("删除成功");
        }
    });

}
function getNotice(userName) {
    console.log(userName);
    $.ajax({
        type: 'POST',
        url: '/msg/getMsg',
        data:{'toUserName':userName},
        // data: data,
        success: function (data) {
            console.log(data);
            $(".friends3").html("");
            for(var i=0;i<data.length;i++) {
                $(".friends3").append("<li ><p>您收到"+data[i].fromUserName+ "的好友请求</p><button class=\"fvbu\" onclick=\"addAgree("+"'"+data[i].fromUserName+"'"+")\">接受</button>"+
                "<button class=\"fvbu\" onclick=\"addRefuse("+"'"+data[i].fromUserName+"'"+")\">拒绝</button></li>")
            }
        }
    });
}











//点击信息显示个人信息按钮
//完成
$(".icon-xiugaiziliao").click(function () {
    $(".Content-Main").slideToggle();
    //显示登录用户数据
    $.ajax({
        url: "/user/findOneUser",
        success:function (res){
            console.log(res);
            //将Json对象转为Json字符串
            var v= JSON.parse(res);
            console.log(v);
            $("#username").val(v.username);
            $("#name").val(v.name);
            $("#birthday").val(v.birthday);
            $("#email").val(v.email);
            $("#tel").val(v.tel);
            $("#message").val(v.instructions);
        },
        error:function (err){
            console.log(err);
        }
    })
});

//点击聊天区好友头像弹出好友个人信息界面
$(".icon-ren1").click(function () {
    $(".Content-Other").slideToggle();
    //显示好友信息，可填写评价
    remainFriendView();

});

//显示好友用户信息
function remainFriendView(){
    $.ajax({
        url:"/user/findFriendMsg",
        data:{'friendName':toName,"userName":userName},
        success:function (res){
            var v = JSON.parse(res);
            $("#username1").val(v.username);
            $("#name1").val(v.name);
            $("#birthday1").val(v.birthday);
            $("#email1").val(v.email);
            $("#tel1").val(v.tel);
            $("#evaluate").val(v.instructions);
            $("#friendview").val()
        },
        error:function (err){
            console.log(err);
        }
    })
}

function addviews(){
    var msg = $("#friendview").val();
    $.ajax({
        url:'/impression/addImpression',//将好友评价保存在数据库
        data:{'fromUserName':userName,'toUserName':toName,'msg':msg},
        success:function (){
            remainFriendView();
        },
        error:function (error){
            console.log(error);
        }

    })
}



//侯雨辰添加
$(function (){
$.ajax({
    url:"/user/getUserName",
    success:function (res) {
        userName=res;
        //聊天窗口显示聊天对象
        $("#chatWith").html(userName);
    }
})
//创建websocket对象
var ws = null;
//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    ws = new WebSocket("ws://localhost:8888/chat");
}
else {
    alert('当前浏览器 Not support websocket')
}

//连接发生错误的回调方法
ws.onerror = function () {
    alert("WebSocket连接发生错误");
};
//给ws绑定事件
ws.onopen= function(){
    //建立连接后做什莫
}

ws.onmessage= function(evt){
    //获取服务端推送到消息
    var datastr=evt.data;
    //将datastr转化为json
    var res=JSON.parse(datastr);
    //判断是否是系统消息
    if(res.isSystem){
        var names=res.message;
        //是系统消息
        //好友列表展示
        var userliststr="";



    /*    //过滤非好友用户
        $.ajax({
            url:'/friend/allFriend',//返回当前用户的所有好友，判断上线用户是否是当前用户好友
            data:{'username':name,'currentUser':userName},
            success:function (data){
                console.log(data);
                if(data=="true"){
                    for(var name of names){
                        if(name != userName) {
                            userliststr += "<li  onclick='showChat(\"" + name + "\")'>" + "<i class='iconfont icon-ren1' title='好友资料'></i>" + "<p>" + name+ "</p>" + "<i class='iconfont icon-shanchuhaoyou1' title='删除好友'style='margin-left: 210px;'></i>"+ "</li>";
                        }
                    }
                    //渲染好友列表
                    $(".chatbar-contacts-uls").html(userliststr);
                }
            },
            error:function (error){
                console.log(error);
            }

        })*/

        for(var name of names){
            if(name != userName) {
                userliststr += "<li  onclick='showChat(\"" + name + "\")'>" + "<i class='iconfont icon-ren1' title='好友资料'></i>" + "<p>" + name+ "</p>" + "<i class='iconfont icon-shanchuhaoyou1' title='删除好友'style='margin-left: 210px;'></i>"+ "</li>";
            }
        }
        //渲染好友列表
        $(".chatbar-contacts-uls").html(userliststr);
    }else{
        //不是系统消息
        //将服务端推送的消息进行展示
        var timer = time();
        var str="<ul class='messages-text-uls'><li class='messages-text-lis'>"
            + "<img src='/online/images/head2.jpg' class='img' style='top: 23px'>"
            + "<p class = 'op'>" + res.message + "</p>" + "<span class='time' style='display: inline'>" + timer + "</span>" + "</li></ul>";

        if(toName==res.fromName){
            $(".messages-text").append(str);
        }
        var chatData=sessionStorage.getItem(res.fromName);
        if(chatData!= null){
            str = chatData+str;
        }
        sessionStorage.setItem(res.fromName,str);
    }
}
//???
$(".icon-shanchuhaoyou1").click(function () {
    doDel()});
var list = document.getElementById('lists').getElementsByTagName("li");
//给每一个li节点添加class属性
for(var i = 0; i < list.length; i++) {
    list[i].onclick = function() {
        if(this.className == "hover") {
            this.className = "";
        } else {
            this.className = "hover";
        }

    }
}
//删除操作
function doDel() {
    for(var i = 0; i < list.length; i++) {
        if(list[i].className == "hover") {
            list[i].parentNode.removeChild(list[i]);
            i--;
        }
    }
}
ws.onclose=function(){

}

//点击发送按钮
//完成消息存入功能
$(".message-btn").click(function () {
    var message = $('.messages-content').val();
    var messages_text = $(".messages-text");
    $(".messages-content").val("");

    $.ajax({
        url:'/chatMsg/addMsg',//前端传：发送账号，接受账号，消息内容，存入数据库
        data:{'sendUserName':userName,'toUserName':toName,'msg':message},
        success:function (data){
            console.log(data);
        },
        error:function (error){
            console.log(error);
        }
    })

    var timer = time();
    if (message != "undefined" && message != '') {
        var str = "<ul class='messages-text-uls'><li class='messages-text-lis'>"
            + "<img src='/online/images/head1.jpg' class='img' style='left: 512px;top: 23px'>"
            + "<p>" + message + "</p>" + "<span class='time' style='display: inline'>" + timer + "</span>" + "</li></ul>";
        messages_text.append(str);
    } else {
        var messageTooltip = "<div class='message-tooltip'>不能发送空白信息</div>";
        $("body").append(messageTooltip);
        setTimeout(function () {
            $(".message-tooltip").hide();
        }, 2000);
    }
    var json = {"toName": toName, "message": message};
    var chatData = sessionStorage.getItem(toName);
    if (chatData != null) {
        str = chatData + str;
    }
    sessionStorage.setItem(toName, str);
    //发送数据给服务端
    ws.send(JSON.stringify(json));

});
});

function downloadMessage(friendName) {  //传入好友ID 的值
    var messageDownload = '';
    $.ajax({
        type: 'post',
        url: '/chatMsg/search',//查询聊天记录
        data: {
            'sendUserName':userName,//当前用户
            'toUserName': friendName, //好友
        },
        success: function (res) {
            console.log(res);
            for (var i = 0; i < res.length; i++) {
                messageDownload +=res[i].sendUserName + "   对  " + res[i].toUseName + "   说   " + res[i].msg + '\n';//谁对谁说
            }
            var friendname = '';
            alert(messageDownload);
            var filename = userName + " 和 " + friendName + ".txt";
            var content = messageDownload;
            var blob = new Blob([content], {type: 'text/plain'});
            var url = window.URL.createObjectURL(blob);
            var a = document.createElement('a');
            a.style = "display: none";
            a.href = url;
            a.download = filename;
            document.body.appendChild(a);
            a.click();
            alert()
            setTimeout(function () {
                document.body.removeChild(a);
                window.URL.revokeObjectURL(url);
            }, 5);
        }
    });
}
