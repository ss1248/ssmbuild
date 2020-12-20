package com.hzq.service;

import com.hzq.dao.AddMsgMapper;
import com.hzq.pojo.AddMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddMsgService {
    List<AddMsg> selectMsgByUserId(int toUserId);
    int getMsgNum(int toUserId);
    boolean deleteMsg(int fromUserId);
    boolean addMsg(int fromUserId,int toUserId,String msg);
}
