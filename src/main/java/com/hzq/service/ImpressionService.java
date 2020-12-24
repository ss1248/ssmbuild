package com.hzq.service;

import com.hzq.pojo.UserImpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImpressionService {

        List<UserImpression> selectImpressionByName(String toUserName);

        boolean deleteImpression(@Param("fromUserName") String fromUserId);

        boolean addImpression(UserImpression userImpression);

}
