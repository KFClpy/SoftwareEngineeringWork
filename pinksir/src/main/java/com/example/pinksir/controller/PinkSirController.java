package com.example.pinksir.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.runner.InitialCache;
import com.example.pinksir.service.GptService;
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

import java.util.*;
import java.util.concurrent.Callable;

@RestController
public class PinkSirController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GptService gptService;
    private static final Logger log = LoggerFactory.getLogger(PinkSirController.class);

    @PostMapping("")
    public JSONObject receive(@RequestBody Map<String, Object> map) {

        JSONObject obj = new JSONObject();
        if (map.get("group_id") == null) return null;
        String group_id=map.get("group_id").toString();
        if (group_id.equals("577749410") || group_id.equals("441327221")) {
            Object getobj = map.get("message");
            if (getobj == null) {
                return null;
            }
            String str = getobj.toString();
            log.info(str);
            List<ACAutomaton.Match> list = InitialCache.getGe().findSensitive(str);
            List<String> forbidWordList = new ArrayList<>();
            for (Iterator<ACAutomaton.Match> iter = list.iterator(); iter.hasNext(); ) {
                ACAutomaton.Match match = iter.next();
                SensitiveInfo info = (SensitiveInfo) match.info;
                forbidWordList.add(info.getTerm());
            }
            if (forbidWordList != null && forbidWordList.size() > 0) {
                for (String w : forbidWordList) {
                    log.info(Joiner.on("|").join(str, w));
                }
                obj.put("delete", "true");
                List<String> strlist = new ArrayList<>();
                strlist.add("少放屁");
                strlist.add("请文明发言");
                strlist.add("请发言符合核心价值观");
                strlist.add("你真是÷");
                strlist.add("脑瘫");
                Random random = new Random();
                obj.put("reply", strlist.get(random.nextInt(strlist.size())));
            } else {
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

