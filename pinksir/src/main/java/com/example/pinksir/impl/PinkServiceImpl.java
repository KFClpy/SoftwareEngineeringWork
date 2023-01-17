package com.example.pinksir.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.service.PinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
@Service

public class PinkServiceImpl implements PinkService {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public JSONObject getQuserMessage(Object obj) {

        JSONObject result=(JSONObject) JSON.toJSON(obj);
        String nickname=result.getString("nickname");
        nickname=nickname.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
        String card=result.getString("card");
        card=card.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
        if (card.equals(""))card=nickname;
        result.put("nickname",nickname);
        result.put("card",card);
        return result;

    }
}
