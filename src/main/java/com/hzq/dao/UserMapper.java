package com.hzq.dao;

import com.hzq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //增加一个用户
    int addUser(User user);

    //删除一个用户
    int deleteUserById(@Param("id") int id);

    //更新一个用户
    int updateUser(User user);

    //通过ID查询一个用户
    User queryUserById(@Param("id") int id);

    //查询全部的用户
    List<User> queryAllUser();

    //通过账号查询一个用户
    User queryUserByName(@Param("username")String username);

    //查询自己对好友的评价
    String querytoFriendReviews(int friendid,String review);

}