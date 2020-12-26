package com.hzq.service;


import com.hzq.pojo.UserFriend;

import java.util.List;

public interface UserFriendService {

    int addFriend(UserFriend userFriend);

    boolean deleteFriend(String userName,String friendName);

    UserFriend queryFriendById(int friendId);

    UserFriend queryFriendByName(String friendName);

    List<UserFriend> queryAllFriend(String userName);

    boolean deleteByName(String username);

}
