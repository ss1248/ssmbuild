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
    @ResponseBody
    public List<UserImpression> getImpression(String toUserName) {
        System.out.println(toUserName);

        UserImpression userImpression= new UserImpression();
        userImpression.setToUserName(toUserName);
        List<UserImpression> list = impressionService.selectImpressionByName(userImpression);

        System.out.println(list);
        System.out.println("#####");
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
        UserImpression userImpression = new UserImpression();
        userImpression.setToUserName(toUserName);
        userImpression.setFromUserName(fromUserName);
        List<UserImpression> list = impressionService.queryImpressionByName(userImpression);

        return list;
    }
    //添加好友评价
    @RequestMapping("/addImpression")
    @ResponseBody
    public String addMsg(String fromUserName, String toUserName,String msg) {

        System.out.println(fromUserName+"\n"+toUserName+"\n"+msg);

/*        UserImpression userImpression = new UserImpression();
        userImpression.setToUserName(toUserName);
        userImpression.setFromUserName(fromUserName);
        List<UserImpression> list = impressionService.queryImpressionByName(userImpression);
        System.out.println(list);
        if(list!=null){
            impressionService.queryImpressionByName();
        }
        */


        UserImpression impression = new UserImpression();
        impression.setFromUserName(fromUserName);
        impression.setToUserName(toUserName);
        impression.setMsg(msg);
        impressionService.addImpression(impression);
        return null;
    }
}
