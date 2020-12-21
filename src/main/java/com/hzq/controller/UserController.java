package com.hzq.controller;

import com.hzq.pojo.User;
import com.hzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller 调 service 层
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


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
    //登录检测接口
    @RequestMapping("/testLogin")
    public String login(User user, Model model){
        System.out.println(user);
        for (User user1 : userService.queryAllUser()) {
            boolean flag1 = user.getUsername().equals(user1.getUsername());
            boolean flag2 = user.getPassword().equals(user1.getPassword());
            if (!(flag1&&flag2)) {
                continue;
            }
            else {
                model.addAttribute("secessful","登陆成功");
                return "login2";
            }
        }
        model.addAttribute("error","用户名或密码错误!");
        return "login1";
    }
    //注册检测接口
    @RequestMapping("/testRegister")
    public String register(User user, Model model, HttpServletRequest request){
        for (User user1 : userService.queryAllUser()) {
            if (user.getUsername().equals(user1.getUsername())) {
                model.addAttribute("error","该用户名已被注册!");
                //return "register2";
                return "register1";
            }else {
                continue;
            }
        }
        if(user.getPassword().length()<6){
            model.addAttribute("error","密码需大于等于6位");
            //return "register1";
            return "register1";
        }else if(!(user.getPassword().equals(request.getParameter("password2")))){
            model.addAttribute("error","两次密码不一致!");
            //return "register1";
            return "register1";
        }
        userService.addUser(user);
        return "redirect:/";

    }



}
