package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMsg {
    private int fromUserId;
    private int toUserId;
    private String msg;

}
