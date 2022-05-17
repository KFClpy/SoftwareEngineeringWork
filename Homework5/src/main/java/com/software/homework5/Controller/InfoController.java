package com.software.homework5.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.software.homework5.Entity.Info;
import com.software.homework5.Service.InfoService;
import com.software.homework5.Util.RedisUtils;
import com.software.homework5.Util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("info")
@RestController
public class InfoController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private InfoService infoService;
    private static final int OK=2000;
    @PostMapping("table")
    public JSONObject showTable()
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Info>list=infoService.getInfoTable(username);
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("addInfo")
    public JSONObject addInfo(@RequestBody Info info)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Info>list=infoService.addInfo(username,info.getName(),info.getGender(),info.getPhone(),info.getEmail());
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("deleteInfo")
    public JSONObject deleteInfo(@RequestParam Integer mid)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Info>list=infoService.deleteInfo(mid,username);
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("searchInfo")
    public JSONObject searchInfo(@RequestParam String name)
    {
        String token= tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Info>list=infoService.searchInfo(name,username);
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("updateInfo")
    public JSONObject updateInfo(@RequestBody Info info)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Info>list=infoService.updateInfo(info.getMid(),username,info.getName(),info.getGender(),info.getPhone(),info.getEmail());
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
}
