package com.hzq.service;

import com.hzq.dao.AddMsgMapper;
import com.hzq.pojo.AddMsg;

import java.util.List;

public class AddMsgServiceImpl implements AddMsgService {
    private AddMsgMapper addMsgMapper;

    public void setAddMsgMapper(AddMsgMapper addMsgMapper) {
        this.addMsgMapper = addMsgMapper;
    }

    public List<AddMsg> selectMsgByUserName(AddMsg addMsg) {
        return addMsgMapper.selectMsgByUserName(addMsg);
    }

    public int getMsgNum(String toUserName) {
        return addMsgMapper.getMsgNum(toUserName);
    }

    public boolean deleteMsg(String fromUserName) {
        return addMsgMapper.deleteMsg(fromUserName);
    }

    public int addMsg(AddMsg addMsg) {
        return addMsgMapper.addMsg(addMsg);
    }
}
