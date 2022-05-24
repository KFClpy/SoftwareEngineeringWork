package com.software.homework5.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.software.homework5.Entity.Award;
import com.software.homework5.Entity.AwardFile;
import com.software.homework5.Service.AwardService;
import com.software.homework5.Util.RedisUtils;
import com.software.homework5.Util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("award")
@RestController
public class AwardController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private AwardService awardService;
    private static final int OK=2000;

    @PostMapping("table")
    public JSONObject showTable()
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Award> list=awardService.getAwardTable(username);
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("addAward")
    public JSONObject addAward(AwardFile awardFile)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Award>list=awardService.addAward(username,awardFile.getAname(),
                awardFile.getNum(),awardFile.getIntro(),awardFile.getFile());
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("updateAward")
    public JSONObject updateAward(AwardFile awardFile)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Award>list=awardService.updateAward(awardFile.getAid(),username,awardFile.getAname(),
                awardFile.getNum(),awardFile.getIntro(),awardFile.getFile());
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("deleteAward")
    public JSONObject deleteAward(@RequestParam Integer []aid)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Award>list=awardService.deleteAward(aid,username);
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("searchAward")
    public JSONObject searchAward(@RequestParam String aname)
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=new JSONObject();
        List<Award>list=awardService.searchAward(username,aname);
        obj.put("table",list);
        obj.put("state",OK);
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        return obj;
    }
    @PostMapping("fillTable")
    public JSONObject fillTable(@RequestParam Integer aid) {
        String token = tokenUtils.getToken();
        String username = tokenUtils.getUsername(token);
        JSONObject obj = new JSONObject();
        Award award = awardService.getAward(aid);
        obj.put("table", award);
        obj.put("state", OK);
        redisUtils.set(token, username, 30, TimeUnit.MINUTES);
        return obj;
    }


}
