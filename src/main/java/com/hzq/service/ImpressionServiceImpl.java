package com.hzq.service;

import com.hzq.dao.ImpressionMapper;
import com.hzq.pojo.UserImpression;

import java.util.List;

public class ImpressionServiceImpl implements ImpressionService{
    private ImpressionMapper impressionMapper;

    public void setImpressionMapper(ImpressionMapper impressionMapper) {
        this.impressionMapper=impressionMapper;
    }

    public List<UserImpression> selectImpressionByUserId(int toUserId) {
        return impressionMapper.selectImpressionByUserId(toUserId);
    }

    public boolean deleteImpression(int fromUserId) {
        return impressionMapper.deleteImpression(fromUserId);
    }

    public boolean addImpression(int fromUserId, int toUserId, String msg) {
        return impressionMapper.addImpression(fromUserId,toUserId,msg);
    }


}
