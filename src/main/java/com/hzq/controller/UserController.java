package com.hzq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.hzq.pojo.User;
import com.hzq.pojo.UserFriend;
import com.hzq.pojo.UserImpression;
import com.hzq.service.ImpressionService;
import com.hzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller 调 service 层
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("ImpressionServiceImpl")
    private ImpressionService impressionService;

    //查询全部的用户，并且返回到一个用户展示界面
    @RequestMapping("/allUser")
    public String list(Model model){
        List<User> userList = userService.queryAllUser();

        model.addAttribute("list",userList);
        return "allUser";
    }

    //跳转到增加好友界面
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }
    //添加用户的请求
    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/user/allUser";//重定向
    }


    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdateUser(int id,Model model){
        User user = userService.queryUserById(id);
        model.addAttribute("QUser",user);
        return "updateUser";

    }

    //修改用户
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        System.out.println(user);
        userService.updateUser(user);

        return "redirect:/user/allUser";
    }


    //删除
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "redirect:/user/allUser";
    }

    //查询
    @RequestMapping("queryUser")
    public String queryUser(String queryUserName,Model model){
        User user = userService.queryUserByName(queryUserName);

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        if(user == null){
            userList = userService.queryAllUser();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",userList);
        return "allUser";
    }
    //登录界面跳转接口
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //注册界面跳转接口
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    //忘记密码跳转接口
    @RequestMapping("/forget")
    public String forget(){
        return "forget";
    }

    //返回用户名
    @RequestMapping("/getUserName")
    @ResponseBody
    public String getUserName(HttpSession session){
        String username=(String)session.getAttribute("user");
        return username;
    }

    //登录检测接口
    @RequestMapping("/testLogin")
    public String login(User user, Model model, HttpSession session){
        System.out.println(user);
        for (User user1 : userService.queryAllUser()) {
            boolean flag1 = user.getUsername().equals(user1.getUsername());
            boolean flag2 = user.getPassword().equals(user1.getPassword());
            if (!(flag1&&flag2)) {
                continue;
            }
            else {      //登录成功
                session.setAttribute("user",user.getUsername());
                return "main2";
            }
        }
        model.addAttribute("error","用户名或密码错误!");
        return "login";
    }
    //注册检测接口
    @RequestMapping("/testRegister")
    public String register(User user, Model model, HttpServletRequest request){
        for (User user1 : userService.queryAllUser()) {
            if (user.getUsername().equals(user1.getUsername())) {
                model.addAttribute("error","该用户名已被注册!");
                return "register";
            }else {
                continue;
            }
        }
        if(user.getPassword().length()<6){
            model.addAttribute("error","密码需大于等于6位");
            return "register";
        }else if(!(user.getPassword().equals(request.getParameter("password2")))){
            model.addAttribute("error","两次密码不一致!");
            return "register";
        }
        Date  date = new Date();
        user.setCreat_at(date);
        userService.addUser(user);

        //打印出用户信息
        System.out.println(user);
        return "redirect:/";
    }

    //修改个人信息
    @RequestMapping("/remain")
    public String remainPerMess(User user,HttpSession session){
        //获得当前用户名

        System.out.println("usrcuowu0"+user);
        String username_temp= (String) session.getAttribute("user");
        //获得数据库中用户原来的信息


        System.out.println("usr12331"+user);
        User user1=userService.queryUserByName(username_temp);
        /*赋值创建时间、密码、ID*/
        System.out.println(user1);

        user.setId(user1.getId());
        user.setCreat_at(user1.getCreat_at());
        user.setPassword(user1.getPassword());
        user.setHeadPortrait(user1.getHeadPortrait());
        session.setAttribute("user",user.getUsername());

        //更新数据库用户信息
        System.out.println(user);
        userService.updateUser(user);
        System.out.println("###3");
        return "main2";
    }

    //通过json查询单个用户
    @RequestMapping("/findOneUser")
    @ResponseBody
    public String findOneUser(HttpSession session) throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        String username = (String) session.getAttribute("user");
        //创建一个对象
        User user= userService.queryUserByName(username);
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        /*如何将一个类封装到Jason中*/
        return str;
    }

    //通过json查询好友信息
    @RequestMapping("/findFriendMsg")
    @ResponseBody
    public String findFriendMsg(String friendName,String userName) throws JsonProcessingException {
        System.out.println(friendName+"  ##  "+userName);
        User user;
        if(friendName==null){
            user = userService.queryUserByName(userName);
        }else{
            user=userService.queryUserByName(friendName);
        }
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);
        System.out.println(str);
        return str;
    }


}
