package com.hzq.service;

import com.hzq.pojo.UserImpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImpressionService {
        List<UserImpression> selectImpressionByUserId(int toUserId);

        boolean deleteImpression(@Param("fromUserId") int fromUserId);

        boolean addImpression(int fromUserId, int toUserId, String msg);

}
