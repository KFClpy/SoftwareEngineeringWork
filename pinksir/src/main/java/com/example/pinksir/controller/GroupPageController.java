package com.example.pinksir.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/group")
public class GroupPageController {
    @Autowired
    private GroupService groupService;
    @PostMapping("add")
    public JSONObject addTable(@RequestParam String group_num,@RequestParam String group_content)
    {
        JSONObject obj=new JSONObject();
        obj.put("state",groupService.addGroup(group_num,group_content));
        obj.put("message","操作成功");
        return obj;
    }
    @PostMapping("list")
    public JSONObject getTable(@RequestParam("page") Integer PageId)
    {
        JSONObject obj=new JSONObject();
        obj.put("table",groupService.getGroupTable(PageId));
        obj.put("state",2000);
        obj.put("message","操作成功");
        obj.put("total",groupService.countGroupTable());
        return obj;
    }
    @PostMapping("delete")
    public JSONObject deleteTable(@RequestParam String group_num)
    {
        JSONObject obj=new JSONObject();
        obj.put("state",groupService.deleteGroupTable(new String[]{group_num}));
        obj.put("message","操作成功");
        return obj;
    }
    @PostMapping("search")
    public JSONObject searchTable(@RequestParam String group_num)
    {
        JSONObject obj=new JSONObject();
        obj.put("table",groupService.findGroup(group_num));
        obj.put("total",1);
        obj.put("state",2000);
        obj.put("message","操作成功");
        return obj;
    }
}
