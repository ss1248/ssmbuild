package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int birthday;
    private String tel;
    private String email;
    private String instructions;
    private String headPortrait;
    private String username;
    private String password;
}
