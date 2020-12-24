package com.hzq.service;

import com.hzq.dao.AddMsgMapper;
import com.hzq.pojo.AddMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddMsgService {
    List<AddMsg> selectMsgByUserName(String toUserName);
    int getMsgNum(String toUserName);
    boolean deleteMsg(String fromUserName);
    boolean addMsg(String fromUserName,String toUserName,String msg);

}
