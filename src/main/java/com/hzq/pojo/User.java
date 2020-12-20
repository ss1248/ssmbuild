package com.hzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户
public class User {
    private int id;     //用户编号
    private String name;    //姓名
    private int birthday;   //出生日期
    private String tel;     //电弧号码
    private String email;   //电子邮件
    private String instructions;    //个人说明
    private String headPortrait;    //用户头像
    private String username;        //账号
    private String password;        //密码
    private Date creat_at;          //创建日期
}
