package com.hzq.service;

import com.hzq.dao.AddMsgMapper;
import com.hzq.pojo.AddMsg;

import java.util.List;

public class AddMsgServiceImpl implements AddMsgService {
    private AddMsgMapper addMsgMapper;
    public void setAddMsgMapper(AddMsgMapper addMsgMapper) {
        this.addMsgMapper=addMsgMapper;
    }

    public List<AddMsg> selectMsgByUserId(int toUserId) {
        return addMsgMapper.selectMsgByUserId(toUserId);
    }

    public int getMsgNum(int toUserId) {
        return addMsgMapper.getMsgNum(toUserId);
    }

    public boolean deleteMsg(int fromUserId) {
        return addMsgMapper.deleteMsg(fromUserId);
    }

    public boolean addMsg(int fromUserId, int toUserId, String msg) {
        return addMsgMapper.addMsg(fromUserId,toUserId,msg);
    }
}
