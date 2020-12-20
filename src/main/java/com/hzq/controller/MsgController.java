package com.hzq.controller;

import com.hzq.dao.AddMsgMapper;
import com.hzq.pojo.AddMsg;
import com.hzq.service.AddMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    @Qualifier("AddMsgServiceImpl")
    private AddMsgService addMsgService;

    @RequestMapping("{toUserId}/getMsg")
    public List<AddMsg> getMsg(int toUserId) {
        List<AddMsg> addMsgList = new ArrayList<AddMsg>();
        addMsgList = addMsgService.selectMsgByUserId(toUserId);
        return addMsgList;
    }

    @RequestMapping("{toUserId}/getMsgNum")
    public int getMsgNum(int toUserId) {
        return  addMsgService.getMsgNum(toUserId);
    }

    @RequestMapping("{fromUserId}/deleteMsg")
    public List<AddMsg> deleteMsg(int fromUserId) {
        addMsgService.deleteMsg(fromUserId);
        return null;
    }

    @RequestMapping("{toUserId}/addMsg")
    public List<AddMsg> addMsg(int fromUserId, int toUserId) {
        String msg = "请求添加你为好友";
        boolean bool =  addMsgService.addMsg(toUserId,fromUserId,msg);
        return null;
    }
}
