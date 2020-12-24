package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFriend {
    private int friendId;
    private String  userName;
    private String friendName;

    public int setFriendId(int friendId) {
        return this.friendId=friendId;
    }
}
