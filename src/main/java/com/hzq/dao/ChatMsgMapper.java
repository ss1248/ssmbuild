package com.hzq.dao;

import com.hzq.pojo.ChatMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatMsgMapper {

    //查询聊天记录
    List<ChatMsg> searchChatMsg(ChatMsg chatMsg);
    //插入用户的聊天记录
    int insertChatMsg(ChatMsg chatMsg);

    //根据双方名字删除聊天记录
    int deleteChatMsgByName(@Param("sendUserName") String sendUserName, @Param("toUserName") String toUserName);

    //根据发送者删除聊天记录
    int deleteChatMsgBySendUserName(String sendUserName);

    //根据接收者删除聊天记录
    int deleteChatMsgByToUserName(String toUserName);
}
