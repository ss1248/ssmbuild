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



    @RequestMapping("/addFriend1")
    @ResponseBody
    public String addFriends(String sendUserName,String toUserName){

        System.out.println(sendUserName+" \n"+toUserName);


        UserFriend userFriend1 = new UserFriend();
        UserFriend userFriend2 = new UserFriend();

        userFriend1.setUserName(sendUserName);
        userFriend1.setFriendName(toUserName);
        userFriend2.setUserName(toUserName);
        userFriend2.setFriendName(sendUserName);
        User user1 = userService.queryUserByName(toUserName);
        User user2 = userService.queryUserByName(sendUserName);
        System.out.println(user1);
        System.out.println(user2);
        userFriend1.setFriendId(user1.getId());
        userFriend2.setFriendId(user2.getId());

        System.out.println(userFriend1);
        System.out.println(userFriend2);

        userFriendService.addFriend(userFriend1);
        System.out.println("##");
        userFriendService.addFriend(userFriend2);
        System.out.println("添加好友成功");
        return null;
    }


    //删除
    @RequestMapping("/deleteFriend")
    @ResponseBody
    public String deleteFriend(String userName,String friendName){
        System.out.println(userName);
        System.out.println(friendName);
        userFriendService.deleteFriend(userName,friendName);
        userFriendService.deleteFriend(friendName,userName);
        System.out.println("##");
        return  "OK";
    }


    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUser(String friendName) throws JsonProcessingException {


        List<User> userList = new ArrayList<User>();
        User user = userService.queryUserByName(friendName);
        userList.add(user);
        System.out.println(userList);
        return userList;

    }

    //测试上线用户是否是当前用户好友
    @RequestMapping("/allFriend")
    @ResponseBody
    public List<UserFriend> allFriend(String currentUser) throws JsonProcessingException {
        //输出所有用户
        System.out.println(currentUser);
        List<UserFriend> friendList = userFriendService.queryAllFriend(currentUser);

        return friendList;
    }
}
