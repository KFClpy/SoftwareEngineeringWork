package com.example.pinksir.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.runner.InitialCache;
import com.example.pinksir.wordfilter.ACAutomaton;
import com.example.pinksir.wordfilter.SensitiveInfo;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class PinkSirController {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(PinkSirController.class);
    @PostMapping("")
    public JSONObject receive(@RequestBody Map<String,Object> map)
    {
        JSONObject obj=new JSONObject();
        if(map.get("group_id")==null)return null;
        if(map.get("group_id").toString().equals("1053835219"))
        {
            Object getobj=map.get("message");
            if(getobj==null){
                return null;
            }
            String str=getobj.toString();
            log.info(str);
            List<ACAutomaton.Match> list = InitialCache.getGe().findSensitive(str);
            List<String> forbidWordList = new ArrayList<>();
            for (Iterator<ACAutomaton.Match> iter = list.iterator(); iter.hasNext();) {
                ACAutomaton.Match match = iter.next();
                SensitiveInfo info = (SensitiveInfo) match.info;
                forbidWordList.add(info.getTerm());
            }
            if (forbidWordList != null && forbidWordList.size() > 0) {
                for (String w : forbidWordList) {
                    log.info(Joiner.on("|").join(str, w));
                }
                obj.put("delete","true");
                obj.put("reply","发言时，请遵守社会主义核心价值观");
            }

        }
        return obj;
    }
}
