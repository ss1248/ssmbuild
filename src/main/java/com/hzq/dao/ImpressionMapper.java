package com.hzq.dao;

import com.hzq.pojo.AddMsg;
import com.hzq.pojo.UserImpression;
import org.apache.ibatis.annotations.Param;

import javax.xml.registry.infomodel.User;
import java.util.List;

public interface ImpressionMapper {

    List<UserImpression> selectImpressionByName(UserImpression userImpression);


    boolean deleteImpression(@Param("fromUserName") String fromUserName);


    boolean addImpression(UserImpression userImpression);

    List<UserImpression> queryImpressionByName(UserImpression userImpression);
}
