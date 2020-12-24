package com.hzq.service;

import com.hzq.dao.ChatMsgMapper;
import com.hzq.pojo.ChatMsg;

import java.util.List;

public class ChatMsgServiceImpl implements ChatMsgService{

    private ChatMsgMapper chatMsgMapper;

    public List<ChatMsg> searchChatMsg(ChatMsg chatMsg) {
        return chatMsgMapper.searchChatMsg(chatMsg);
    }

    //插入用户的聊天记录
    public int addChatMsg(ChatMsg chatMsg) {
        return chatMsgMapper.addChatMsg(chatMsg);
    }

    //根据双方名字删除聊天记录
    public int deleteChatMsgByName(String sendUserName, String toUserName) {
        return chatMsgMapper.deleteChatMsgByName(sendUserName,toUserName);
    }

    //根据发送者删除聊天记录
    public int deleteChatMsgBySendUserName(String sendUserName) {
        return chatMsgMapper.deleteChatMsgBySendUserName(sendUserName);
    }

    //根据接收者删除聊天记录
    public int deleteChatMsgByToUserName(String toUserName) {
        return chatMsgMapper.deleteChatMsgByToUserName(toUserName);
    }

    public void setChatMsgMapper(ChatMsgMapper chatMsgMapper) {
        this.chatMsgMapper=chatMsgMapper;
    }
}
