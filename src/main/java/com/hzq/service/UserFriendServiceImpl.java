package com.hzq.service;

import com.hzq.dao.UserFriendMapper;
import com.hzq.dao.UserMapper;
import com.hzq.pojo.UserFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class UserFriendServiceImpl implements UserFriendService {
    private UserFriendMapper userFriendMapper;

    public void setUserFriendMapper(UserFriendMapper userFriendMapper) {
        this.userFriendMapper = userFriendMapper;
    }


    public int addFriend(UserFriend userFriend) {
        return userFriendMapper.addFriend(userFriend);
    }

    public String deleteFriend(String sendUserName, String toUserName) {
        return userFriendMapper.deleteFriend(sendUserName,toUserName);
    }
    public UserFriend queryFriendById(int friendId){
        return userFriendMapper.queryFriendById(friendId);
    }
    public UserFriend queryFriendByName(String friendName){
        return userFriendMapper.queryFriendByName(friendName);
    }

    public List<UserFriend> queryAllFriend(String userName) {
        return userFriendMapper.queryAllFriend(userName);
    }
}
