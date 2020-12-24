package com.hzq.dao;

import com.hzq.pojo.UserFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFriendMapper {


    int addFriend(UserFriend userFriend);

    String deleteFriend(@Param("userName")String userName,@Param("friendName")String friendName);

    UserFriend queryFriendById(@Param("friendId") int friendId);

    UserFriend queryFriendByName(@Param("friendName") String friendName);

    List<UserFriend> queryAllFriend();

}
