package com.example.pinksir.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.controller.PinkSirController;
import com.example.pinksir.service.GptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class GptSerciceImpl implements GptService {
    @Autowired
    RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(PinkSirController.class);
    @Override

    public void gpt3(String str,String group_id)
    {
        String url = "https://api.openai.com/v1/chat/completions";
        System.setProperty("java.net.useSystemProxies", "true");
        JSONObject postData = new JSONObject();
        postData.put("model", "gpt-3.5-turbo");
        JSONObject messages = new JSONObject();
        messages.put("role", "user");
        messages.put("content", str);
        List<JSONObject>list=new ArrayList<>();
        list.add(messages);
        postData.put("messages",list);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer ");
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(postData, headers);
        JSONObject json = JSONObject.parseObject(restTemplate.postForEntity(url, httpEntity, String.class).getBody());
        JSONArray jsonArray = json.getJSONArray("choices");
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        JSONObject message=(JSONObject) jsonObject.get("message");
        String input= (String) message.get("content");
        if(message.get("content").toString().indexOf(1)=='\n')
            input=message.get("content").toString().substring(2);
        log.info("\ngroup_id:"+group_id+"\noutput:"+input);
        String go_cq_url="http://127.0.0.1:5700/send_group_msg";
        JSONObject gocqPostData=new JSONObject();
        gocqPostData.put("group_id",group_id);
        gocqPostData.put("message",input);
        restTemplate.postForEntity(go_cq_url, gocqPostData, String.class);
    }
}
