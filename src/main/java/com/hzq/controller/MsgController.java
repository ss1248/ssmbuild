package com.hzq.controller;

import com.hzq.dao.AddMsgMapper;
import com.hzq.pojo.AddMsg;
import com.hzq.service.AddMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    @Qualifier("AddMsgServiceImpl")
    private AddMsgService addMsgService;

    @RequestMapping("/getMsg")
    @ResponseBody
    public List<AddMsg> getMsg(String toUserName) {
        System.out.println(toUserName);
        List<AddMsg> addMsgList = new ArrayList<AddMsg>();
        addMsgList = addMsgService.selectMsgByUserName(toUserName);
        System.out.println(addMsgList);
        return addMsgList;
    }

//    @RequestMapping("{toUserName}/getMsgNum")
//    public int getMsgNum(String toUserName) {
//        return  addMsgService.getMsgNum(toUserName);
//    }

    @RequestMapping("deleteMsg")
    public List<AddMsg> deleteMsg(String fromUserName) {
        addMsgService.deleteMsg(fromUserName);
        return null;
    }

    @RequestMapping("/addMsg")
    @ResponseBody
    public int addMsg(String fromUserName, String toUserName) {
        System.out.println(fromUserName+"\n"+toUserName);
        String msg = "请求添加你为好友";
        AddMsg addMsg=new AddMsg();
        addMsg.setFromUserName(fromUserName);
        addMsg.setToUserName(toUserName);
        addMsg.setMsg(msg);
        System.out.println(addMsg);
        addMsgService.addMsg(addMsg);
        return 0;
    }

}