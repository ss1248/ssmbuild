package com.hzq.service;

import com.hzq.dao.ImpressionMapper;
import com.hzq.pojo.UserImpression;

import java.util.List;

public class ImpressionServiceImpl implements ImpressionService{
    private ImpressionMapper impressionMapper;

    public void setImpressionMapper(ImpressionMapper impressionMapper) {
        this.impressionMapper=impressionMapper;
    }

    public List<UserImpression> selectImpressionByName(String toUserName) {
        return impressionMapper.selectImpressionByName(toUserName);
    }

    public boolean deleteImpression(String fromUserName) {
        return impressionMapper.deleteImpression(fromUserName);
    }

    public boolean addImpression(UserImpression userImpression) {
        return impressionMapper.addImpression(userImpression);
    }

}
