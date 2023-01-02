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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GPT3Test {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void PostTest()
    {
        String url="https://api.openai.com/v1/completions";
        JSONObject postData=new JSONObject();
        postData.put("model","text-davinci-003");
        postData.put("prompt","世界上最伟大的滑雪运动员是谁");
        postData.put("max_tokens",4000);
        postData.put("temperature",0);
        postData.put("top_p",1);
        postData.put("frequency_penalty",0);
        postData.put("presence_penalty",0.6);
        List<String> list=new ArrayList<>();
        list.add(" Human:");
        list.add(" AI:");
        postData.put("stop",list);
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization","Bearer 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");
        HttpEntity<JSONObject> httpEntity=new HttpEntity<>(postData,headers);
        JSONObject json=JSONObject.parseObject(restTemplate.postForEntity(url,httpEntity,String.class).getBody());
        JSONArray jsonArray=json.getJSONArray("choices");
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        System.out.println(jsonObject.get("text"));
    }
}
