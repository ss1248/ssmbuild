package com.hzq.controller;

import com.hzq.pojo.AddMsg;
import com.hzq.pojo.UserImpression;
import com.hzq.service.ImpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/impression")
public class ImpressionController {
    @Autowired
    @Qualifier("ImpressionServiceImpl")
    private ImpressionService impressionService;

//    获取好友评价
    @RequestMapping("/getImpression")
    public List<UserImpression> getImpression(String toUserName) {
        List<UserImpression> list = new ArrayList<UserImpression>();
        list = impressionService.selectImpressionByName(toUserName);
        return list;
    }

    @RequestMapping("/deleteImpression")
    public List<UserImpression> deleteImpression(String fromUserName) {
        impressionService.deleteImpression(fromUserName);
        return null;
    }

    //获取一对一好友评价
    @RequestMapping("/queryImpressionPer")
    @ResponseBody
    public List<UserImpression> queryImpressionPer(String toUserName, String fromUserName){
        System.out.println(toUserName);
        System.out.println(fromUserName);
        System.out.println("%%%%");
        List<UserImpression> list = impressionService.queryImpressionByName(fromUserName,
                toUserName);
        System.out.println(list);
        System.out.println("@@@");
        return list;
    }
    //添加好友评价
    @RequestMapping("/addImpression")
    @ResponseBody
    public List<UserImpression> addMsg(String fromUserName, String toUserName,String msg) {
        System.out.println(fromUserName+"\n"+toUserName+"\n"+msg);
        UserImpression impression = new UserImpression();
        impression.setFromUserName(fromUserName);
        impression.setToUserName(toUserName);
        impression.setMsg(msg);
        impressionService.addImpression(impression);
        System.out.println("######");
        return null;
    }
}
