package com.hzq.service;

import com.hzq.pojo.UserImpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImpressionService {

        List<UserImpression> selectImpressionByName(UserImpression userImpression);

        boolean deleteImpression(@Param("fromUserName") String fromUserId);

        boolean addImpression(UserImpression userImpression);

       List<UserImpression> queryImpressionByName(UserImpression userImpression);

}
