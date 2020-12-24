package com.hzq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzq.pojo.User;
import com.hzq.pojo.UserFriend;
import com.hzq.service.UserFriendService;
import com.hzq.service.UserService;
import com.hzq.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/friend")
public class UserFriendController {
    @Autowired
    @Qualifier("UserFriendServiceImpl")
    private UserFriendService userFriendService;
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

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

    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUser(String friendName) throws JsonProcessingException {
        System.out.println(friendName);
        System.out.println("####");

//        UserServiceImpl userService=new UserServiceImpl();

        List<User> userList = new ArrayList<User>();
        User user = userService.queryUserByName(friendName);
        userList.add(user);
        System.out.println(userList);
        return userList;

        /*System.out.println(user);
        List<User> userList = new ArrayList<User>();
        userList.add(user);

        ObjectMapper mapper = new ObjectMapper();

        if(user == null){
            userList = userService.queryAllUser();
        }
        String v = mapper.writeValueAsString(userList);
        System.out.println(v);
        return v;*/
    }
}
