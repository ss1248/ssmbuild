package com.hzq.controller;

import com.hzq.pojo.UserFriend;
import com.hzq.service.UserFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/friend")
public class UserFriendController {
    @Autowired
    @Qualifier("UserFriendServiceImpl")
    private UserFriendService userFriendService;

    @RequestMapping("/allFriend")
    public String list(Model model){
        List<UserFriend> friendList = userFriendService.queryAllFriend();
        model.addAttribute("list",friendList);
        return "allFriend";
    }

    //跳转到增加好友界面
    @RequestMapping("/toAddFriend")
    public String toAddFriend() {
        return "addFriend";
    }

    @RequestMapping("/addFriend")
    public String addFriend(int userid, int friendId){
        userFriendService.addFriend(userid,friendId);
        userFriendService.addFriend(friendId,userid);

        return "allFriend";
    }

    //删除
    @RequestMapping("/deleteFriend")
    public String deleteFriend(int userid, int friendId){
        userFriendService.deleteFriend(userid,friendId);
        userFriendService.deleteFriend(friendId,userid);
        return "allFriend";
    }


    @RequestMapping("queryFriendByName")
    public String queryFriendByName(String queryFriendName, Model model) {
        UserFriend userFriend = userFriendService.queryFriendByName(queryFriendName);

        List<UserFriend> friendList = new ArrayList<UserFriend>();
        friendList.add(userFriend);

        if (friendList == null) {
            friendList = userFriendService.queryAllFriend();
            model.addAttribute("error", "未查到");
        }

        model.addAttribute("list", friendList);
        return "allFriend";
    }
    @RequestMapping("queryFriendById")
    public String queryFriendById(int queryFriendId, Model model) {
        UserFriend userFriend = userFriendService.queryFriendById(queryFriendId);

        List<UserFriend> friendList = new ArrayList<UserFriend>();
        friendList.add(userFriend);

        if (friendList == null) {
            friendList = userFriendService.queryAllFriend();
            model.addAttribute("error", "未查到");
        }

        model.addAttribute("list", friendList);
        return "allFriend";
    }
}
