package com.hzq.dao;

import com.hzq.pojo.AddMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddMsgMapper {

    List<AddMsg> selectMsgByUserName(@Param("toUserName") String toUserName);

    int getMsgNum(@Param("toUserName") String toUserName);

    boolean deleteMsg(@Param("fromUserName") String fromUserName);

    int addMsg(AddMsg addMsg);
}

