package com.hzq.dao;

import com.hzq.pojo.AddMsg;
import com.hzq.pojo.UserImpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImpressionMapper {
    List<UserImpression> selectImpressionByUserId(@Param("toUserId") int toUserId);
    boolean deleteImpression(@Param("fromUserId") int fromUserId);
    boolean addImpression(@Param("fromUserId")int fromUserId,@Param("toUserId")int toUserId,  @Param("msg")String msg);
}
