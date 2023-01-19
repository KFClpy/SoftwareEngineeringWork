package com.example.pinksir.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.service.QuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/member")

public class QuserPageController {
    @Autowired
    QuserService quserService;
    @PostMapping("list")
    public JSONObject getTable(@RequestParam("page") Integer PageId,@RequestParam String group_num)
    {
        JSONObject obj=new JSONObject();
        obj.put("table",quserService.getQuserTable(PageId,group_num));
        obj.put("state",2000);
        obj.put("message","操作成功");
        obj.put("total",quserService.countAllTable(group_num));
        return obj;
    }
    @PostMapping("search")
    public  JSONObject searchFromTable(@RequestParam("qq") String unum,@RequestParam String group_num)
    {
        JSONObject obj=new JSONObject();
        obj.put("table",quserService.findQuserByNum(1,group_num,unum));
        obj.put("state",2000);
        obj.put("message","操作成功");
        return obj;
    }
    @PostMapping("clean")
    public JSONObject cleanTable(@RequestParam String group_num)
    {
        JSONObject obj=new JSONObject();
        obj.put("state",quserService.delelteAll(group_num));
        obj.put("message","操作成功");
        return obj;
    }
    @PostMapping("echarts")
    public JSONObject getChart(@RequestParam String group_num,@RequestParam("qq") String unum)
    {
        JSONObject obj=new JSONObject();
        obj.put("table",quserService.getQuserData(group_num,unum));
        obj.put("state",2000);
        obj.put("message","操作成功");
        return obj;
    }
}
