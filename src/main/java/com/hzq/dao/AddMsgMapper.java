package com.hzq.dao;

import com.hzq.pojo.AddMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddMsgMapper {

    List<AddMsg> selectMsgByUserId(@Param("toUserId") int toUserId);
    int getMsgNum(@Param("toUserId") int toUserId);
    boolean deleteMsg(@Param("fromUserId") int fromUserId);
    boolean addMsg(@Param("fromUserId")int fromUserId,@Param("toUserId")int toUserId,  @Param("msg")String msg);
}
