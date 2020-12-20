package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//聊天记录
public class ChatMsg {
    private int sendUserid;     //发送者ID
    private int toUserid;       //接受者ID
    private int create_at;      //发送时间
    private int update_at;      //已读时间
    private String msg;         //发送内容
    private int isSend;         //是否发送

}
