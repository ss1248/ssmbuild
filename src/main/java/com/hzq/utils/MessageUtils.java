package com.hzq.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzq.pojo.ResultMessage;

public class MessageUtils {
    public MessageUtils() {
    }

    public static String getMessage(boolean isSystemMessage, String fromName, Object message) {
        try {
            ResultMessage result = new ResultMessage();
            result.setISSystem(isSystemMessage);
            result.setMessage(message);
            if (fromName != null) {
                result.setFromName(fromName);
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result);
        } catch (JsonProcessingException var5) {
            var5.printStackTrace();
            return null;
        }
    }
}