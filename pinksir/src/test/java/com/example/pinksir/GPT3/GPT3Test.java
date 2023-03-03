package com.example.pinksir.GPT3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootTest
public class GPT3Test {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void PostTest() {
        String str = "你是谁";
        String url = "https://api.openai.com/v1/chat/completions";
        System.setProperty("java.net.useSystemProxies", "true");
        JSONObject postData = new JSONObject();
        postData.put("model", "gpt-3.5-turbo");
        JSONObject messages = new JSONObject();
        System.getProperties().put("socksProxySet","true");
        System.getProperties().put("socksProxyHost","127.0.0.1");
        System.getProperties().put("socksProxyPort","10793");
        messages.put("role", "user");
        messages.put("content", str);
        List<JSONObject>list=new ArrayList<>();
        list.add(messages);
        postData.put("messages",list);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer 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");
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(postData, headers);
        JSONObject json = JSONObject.parseObject(restTemplate.postForEntity(url, httpEntity, String.class).getBody());
        JSONArray jsonArray = json.getJSONArray("choices");
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        JSONObject message=(JSONObject) jsonObject.get("message");
        String input=message.get("content").toString().substring(2);
        System.out.println(input);
    }
}
