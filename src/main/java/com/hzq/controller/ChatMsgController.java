package com.hzq.controller;

import com.hzq.pojo.ChatMsg;
import com.hzq.service.ChatMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chatMsg")
public class ChatMsgController {
    @Autowired
    @Qualifier("ChatMsgServiceImpl")
    private ChatMsgService chatMsgService;
    //
    @RequestMapping("/search/{sendUserName}/{toUserName}")
    public List<ChatMsg> search(String sendUserName, String toUserName) {
        List<ChatMsg> chatMsgs = new ArrayList<ChatMsg>();
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

    @RequestMapping("/addMsg")
    public boolean addMsg(String sendUserName, String toUserName, String msg){
        //放入数据库
        ChatMsg chatMsg = new ChatMsg();
        chatMsg.setSendUserName(sendUserName);
        chatMsg.setToUserName(toUserName);
        chatMsg.setMsg(msg);
        chatMsgService.insertChatMsg(chatMsg);
        return true;
    }

}
