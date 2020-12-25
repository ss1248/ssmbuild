package com.hzq.dao;

import com.hzq.pojo.AddMsg;
import com.hzq.pojo.User;
import com.hzq.pojo.UserImpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImpressionMapper {

    List<UserImpression> selectImpressionByName(@Param("toUserName") String toUserName);


    boolean deleteImpression(@Param("fromUserName") String fromUserName);


    boolean addImpression(UserImpression userImpression);

    List<UserImpression> queryImpressionByName(String fromUserName, String toUserName);
}
