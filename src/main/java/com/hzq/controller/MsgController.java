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

    @RequestMapping("{toUserName}/getMsg")
    public List<AddMsg> getMsg(String toUserName) {
        List<AddMsg> addMsgList = new ArrayList<AddMsg>();
        addMsgList = addMsgService.selectMsgByUserName(toUserName);
        return addMsgList;
    }

//    @RequestMapping("{toUserName}/getMsgNum")
//    public int getMsgNum(String toUserName) {
//        return  addMsgService.getMsgNum(toUserName);
//    }

    @RequestMapping("{fromUserName}/deleteMsg")
    public List<AddMsg> deleteMsg(String fromUserName) {
        addMsgService.deleteMsg(fromUserName);
        return null;
    }

    @RequestMapping("{toUserName}/addMsg")
    public List<AddMsg> addMsg(String fromUserName, String toUserName) {
        String msg = "请求添加你为好友";
        boolean bool =  addMsgService.addMsg(toUserName,fromUserName,msg);
        return null;
    }

}