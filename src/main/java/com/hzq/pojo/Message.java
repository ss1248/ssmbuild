package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    //浏览器发送给服务端的数据
    private String toName;
    private  String message;

}


