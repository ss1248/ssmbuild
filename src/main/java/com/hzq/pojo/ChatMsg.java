package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//聊天记录
public class ChatMsg {
    private String sendUserName;     //发送者ID
    private String toUserName;       //接受者ID
    private String msg;         //发送内容
    private int isSend;         //是否发送

}
