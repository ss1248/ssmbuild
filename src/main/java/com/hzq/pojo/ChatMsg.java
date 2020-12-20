package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMsg {
    private int sendUserid;
    private int toUserid;
    private int create_at;
    private int update_at;
    private String msg;
    private int isSend;

}
