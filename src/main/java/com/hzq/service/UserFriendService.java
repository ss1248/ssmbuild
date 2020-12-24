package com.hzq.service;


import com.hzq.pojo.UserFriend;

import java.util.List;

public interface UserFriendService {

    int addFriend(UserFriend userFriend);

    String deleteFriend(String sendUserName,String toUserName);

    UserFriend queryFriendById(int friendId);

    UserFriend queryFriendByName(String friendName);

    List<UserFriend> queryAllFriend(String userName);

}
