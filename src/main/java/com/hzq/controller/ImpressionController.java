package com.hzq.controller;

import com.hzq.pojo.AddMsg;
import com.hzq.pojo.UserImpression;
import com.hzq.service.ImpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/impression")
public class ImpressionController {
    @Autowired
    @Qualifier("ImpressionServiceImpl")
    private ImpressionService impressionService;

    @RequestMapping("{touserId}/getImpression")
    public List<UserImpression> getImpression(int toUserId) {
        List<UserImpression> list = new ArrayList<UserImpression>();
        list = impressionService.selectImpressionByUserId(toUserId);
        return list;
    }
    @RequestMapping("{fromUserId}/deleteImpression")
    public List<UserImpression> deleteImpression(int fromUserId) {
        impressionService.deleteImpression(fromUserId);
        return null;
    }

    @RequestMapping("{touserId}/addImpression")
    public List<UserImpression> addMsg(int fromUserId, int toUserId) {
        String msg = "";
       impressionService.addImpression(toUserId,fromUserId,msg);
        return null;
    }
}
