package com.hzq.service;

import com.hzq.pojo.User;
import com.hzq.pojo.UserFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFriendService {
    UserFriend addFriend(int userid,int friendId);

    String deleteFriend(int userid,int friendId);
    UserFriend queryFriendById(int friendId);
    UserFriend queryFriendByName(String friendName);
    List<UserFriend> queryAllFriend();

}
