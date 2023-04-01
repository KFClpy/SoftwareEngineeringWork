package com.example.pinksir.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.entity.Quser;
import com.example.pinksir.runner.InitialCache;
import com.example.pinksir.service.FilterService;
import com.example.pinksir.service.GptService;
import com.example.pinksir.service.PinkService;
import com.example.pinksir.service.QuserService;
import com.example.pinksir.wordfilter.ACAutomaton;
import com.example.pinksir.wordfilter.SensitiveInfo;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.*;
import java.util.concurrent.Callable;

@RestController
public class PinkSirController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GptService gptService;
    @Autowired
    private FilterService filterService;
    @Autowired
    private QuserService quserService;
    @Autowired
    private PinkService pinkService;
    private static final Logger log = LoggerFactory.getLogger(PinkSirController.class);

    @PostMapping("")
    public JSONObject receive(@RequestBody Map<String, Object> map) {

        JSONObject obj = new JSONObject();
        if (map.get("group_id") == null) return null;
        String group_id=map.get("group_id").toString();
        if (filterService.isExist(group_id)) {
            Object getobj = map.get("message");
            if (getobj == null) {
                return null;
            }
            Object getsender=map.get("sender");
            if(getsender==null){
                return null;
            }
            JSONObject sender=pinkService.getQuserMessage(getsender);
            String str = getobj.toString();
            log.info(str);
            if (filterService.isInvalid(str)) {
                quserService.updateQuserTable(sender.getString("nickname"),
                        group_id,sender.getString("user_id"),1,
                        new Date(System.currentTimeMillis()),sender.getString("card"));
                obj.put("delete", "true");
                obj.put("reply", filterService.randomReply());
            }
            else {

                String flag = "[CQ:at,qq=1374457571]";
                int index = str.indexOf(flag);
                if (index == -1) return null;
                String remains = str.substring(index + flag.length());
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        gptService.gpt3(remains,group_id);
                    }
                }.start();
            }

        }
        return obj;
    }

}

