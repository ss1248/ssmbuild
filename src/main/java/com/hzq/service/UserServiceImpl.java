package com.hzq.service;

import com.hzq.dao.UserMapper;
import com.hzq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService{

    //service层调dao层： 组合Dao
    //@Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
