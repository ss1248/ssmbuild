package com.hzq.service;

import com.hzq.dao.ImpressionMapper;
import com.hzq.pojo.User;
import com.hzq.pojo.UserImpression;

import java.util.List;

public class ImpressionServiceImpl implements ImpressionService{
    private ImpressionMapper impressionMapper;

    public void setImpressionMapper(ImpressionMapper impressionMapper) {
        this.impressionMapper=impressionMapper;
    }

    public List<UserImpression> selectImpressionByName(UserImpression userImpression) {
        return impressionMapper.selectImpressionByName(userImpression);
    }

    public boolean deleteImpression(String fromUserName) {
        return impressionMapper.deleteImpression(fromUserName);
    }

    public boolean addImpression(UserImpression userImpression) {
        return impressionMapper.addImpression(userImpression);
    }

    public List<UserImpression> queryImpressionByName(UserImpression userImpression){
        return impressionMapper.queryImpressionByName(userImpression);
    }
}
