// var data = [
//     {name: "黄小小"},
//     {name: "李小小"},
//     {name: "肖大大"},
//     {name: "江大大"},
//     {name: "黄某某"},
//     {name: "陈某某"},
//     {name: "苏某某"},
//     {name: "陈小小"},
//     {name: "刘某某"},
//     {name: "黄大大"},
//     {name: "王闯"}
// ];
//
// var html = "";
// for (var i = 0; i < data.length; i++) {
//     html += "<li>" + "<i class='iconfont'>&#xe752;</i>" + "<p>" + data[i].name + "</p>" + "</li>";
// }
let toName; //消息接受者账号
let userName;   //发送消息者的账号
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
});

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


// //搜索功能
// $('.search-text').bind('keyup', function () {
//     var txt = $('.search-text').val();
//
//     txt = txt.replace(/\s/g, '');
//     $('.chatbar-contacts-uls li').each(function () {
//         if (!$(this).is(':contains(' + txt + ')')) {
//             $(this).hide();
//         } else {
//             $(this).show();
//         }
//     });
//     return false;
// });


//添加好友搜索功能
$("#find").click(function (){
    var name =$("#findArea").val();
    $.ajax({
        type:'post',
        // async:false,
        url:"/friend/queryUser",//后端取值接口，给搜索账号（name），返回搜索用户信息
        data:{'friendName':name},
        success:function (data){
            //前端片拼接
            // $("#findArea").val("");
            console.log(data);

        },
        error(error){
            console.log(error);
        }
    })
})

//点击添加好友按钮,获得显示用户的账号name
//
$("#").click(function (name){
    $.ajax({
        url:'',//
        data:{'fromUserName':userName,"toUseName":name},
        success:function (data){
            //成功发送验证消息
        },
        error:function (error){
            console.log(error);
        }
    })
})

//点击消息发送按钮，将消息存入数据库
$("#send").click(function (){
    var msg = $("#send").val();
    $.ajax({
        url:'',//前端传：发送账号，接受账号，消息内容，存入数据库
        data:{'fromUserName':userName,"toUseName":toName,'msg':msg},
        success:function (data){
            console.log();
        },
        error:function (error){
            console.log(error);
        }
    })
})

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

//点击消息，显示好友请求
$("#send").click(function (){
    $.ajax({
        url:'',//前端传：用户账号,返回所有消息，显示在消息页面上
        data:{'toUserName':userName},
        success:function (data){
            //将返回的消息显示在列表
            console.log();
        },
        error:function (error){
            console.log(error);
        }
    })
})
//点击同意好友请求
$("#").click(function (){
    var msg = $("#friendname").val();
    $.ajax({
        url:'',//前端传,好友请求账号，好友接受账号，将好友关系存入数据库存入数据库
        data:{'fromUserName':userName,"toUseName":name},
        success:function (data){
            console.log();
        },
        error:function (error){
            console.log(error);
        }
    })
})

//拒绝好友请求
$("#").click(function (){
    var msg = $("#send").val();
    $.ajax({
        url:'',//前端传：发送账号，接受账号，将数据库中好友请求删除
        data:{'fromUserName':userName,"toUseName":name},
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

$("#heading").hover(function () {
    $(".Content-Main").slideToggle();
});

//点击信息显示按钮
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

//点击修改好友评价
function remainFriendView(){
    $.ajax({
        url:"/user/findFriendMsg",
        data:{'friendName':toName},
        success:function (res){
            var v = JSON.parse(res);
            $("#username1").val(v.username);
            $("#name1").val(v.name);
            $("#birthday1").val(v.birthday);
            $("#email1").val(v.email);
            $("#tel1").val(v.tel);
        },
        error:function (err){
            console.log(err);
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




        //过滤非好友用户
        $.ajax({
            url:'',//返回当前用户的所有好友，判断上线用户是否是当前用户好友
            data:{'':userName},
            success:function (data){
                for(var i=0;i=data.length;i++){

                }
            },
            error:function (){

            }

        })


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
$(".message-btn").click(function () {
    var message = $('.messages-content').val();
    var messages_text = $(".messages-text");
    $(".messages-content").val("");
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

