package com.hzq.service;

import com.hzq.pojo.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    //删除一个用户
    int deleteUserById(int id);

    //更新一个用户
    int updateUser(User user);

    //查询一个用户
    User queryUserById(int id);

    //查询全部的用户
    List<User> queryAllUser();

    User queryUserByName(String username);
}
