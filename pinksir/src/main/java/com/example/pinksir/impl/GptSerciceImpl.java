package com.example.pinksir.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.service.GptService;
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
    @Override

    public void gpt3(String str,String group_id)
    {
        String url = "https://api.openai.com/v1/completions";
        JSONObject postData = new JSONObject();
        postData.put("model", "text-davinci-003");
        postData.put("prompt", str);
        postData.put("max_tokens", 4000);
        postData.put("temperature", 0);
        postData.put("top_p", 1);
        postData.put("frequency_penalty", 0);
        postData.put("presence_penalty", 0.6);
        List<String> stoplist = new ArrayList<>();
        stoplist.add(" Human:");
        stoplist.add(" AI:");
        postData.put("stop", stoplist);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer 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");
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(postData, headers);
        JSONObject json = JSONObject.parseObject(restTemplate.postForEntity(url, httpEntity, String.class).getBody());
        JSONArray jsonArray = json.getJSONArray("choices");
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String input=jsonObject.getString("text").substring(2);
        String go_cq_url="http://127.0.0.1:5700/send_group_msg";
        JSONObject gocqPostData=new JSONObject();
        gocqPostData.put("group_id",group_id);
        gocqPostData.put("message",input);
        restTemplate.postForEntity(go_cq_url, gocqPostData, String.class);
    }
}
