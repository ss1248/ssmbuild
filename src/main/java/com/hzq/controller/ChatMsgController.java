package com.hzq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzq.pojo.ChatMsg;
import com.hzq.service.ChatMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chatMsg")
public class ChatMsgController {
    @Autowired
    @Qualifier("ChatMsgServiceImpl")
    private ChatMsgService chatMsgService;
    //
    @RequestMapping("/search")
    @ResponseBody
    public List<ChatMsg> serach(String sendUserName,  String toUserName) {
        List<ChatMsg> chatRecords = new ArrayList<ChatMsg>();
        ChatMsg chatMsg = new ChatMsg();
        chatMsg.setSendUserName(sendUserName);
        chatMsg.setToUserName(toUserName);
        return chatMsgService.searchChatMsg(chatMsg);
    }


    //删除聊天记录
    @RequestMapping("/delete/{sendUserName}/{toUserName}")
    public List<ChatMsg> deleteChatMsgByName(String sendUserName, String toUserName) {
        chatMsgService.deleteChatMsgByName(sendUserName, toUserName);
        return null;
    }

    //将聊天记录存入数据库
    @RequestMapping("/addMsg")
    @ResponseBody
    public int addMsg(String sendUserName, String toUserName, String msg){
        //放入数据库
        System.out.println("###");
        System.out.println(msg);
        ChatMsg chatMsg = new ChatMsg();
        chatMsg.setSendUserName(sendUserName);
        chatMsg.setToUserName(toUserName);
        chatMsg.setMsg(msg);
        System.out.println(chatMsg);

        chatMsgService.addChatMsg(chatMsg);

        System.out.println("###");
        return 0;
    }

}
