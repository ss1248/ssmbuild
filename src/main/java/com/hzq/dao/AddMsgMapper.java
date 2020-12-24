package com.hzq.dao;

import com.hzq.pojo.AddMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddMsgMapper {
    List<AddMsg> selectMsgByUserName(@Param("toUserName") String toUserName);

    int getMsgNum(@Param("toUserName") String toUserName);

    boolean deleteMsg(@Param("fromUserName") String fromUserName);

    boolean addMsg(@Param("fromUserName") String fromUserName,@Param("toUserName") String toUserName,  @Param("msg")String msg);
}

