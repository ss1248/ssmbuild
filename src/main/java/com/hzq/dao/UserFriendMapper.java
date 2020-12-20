package com.hzq.dao;

import com.hzq.pojo.User;
import com.hzq.pojo.UserFriend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFriendMapper {
    UserFriend addFriend(@Param("userid")int userid,@Param("friendId")int friendId);

    String deleteFriend(@Param("userid")int userid,@Param("friendId")int friendId);
    UserFriend queryFriendById(@Param("friendId") int friendId);
    UserFriend queryFriendByName(@Param("friendName") String friendName);
    List<UserFriend> queryAllFriend();

}
