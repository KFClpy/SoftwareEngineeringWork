package com.example.pinksir.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pinksir.entity.Word;
import com.example.pinksir.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("sys")
@RestController
public class WordPageController {
    @Autowired
    private WordService wordService;
    @PostMapping("list")
    public JSONObject showWordTable(@RequestParam("page") Integer PageId)
    {
        JSONObject obj=new JSONObject();
        obj.put("table",wordService.getWordTable(PageId));
        obj.put("state",2000);
        obj.put("message","成功");
        obj.put("total",wordService.countAll());
        return obj;
    }
//    @PostMapping("search")
//    public JSONObject showSearchTable(@RequestParam);
    @PostMapping("update")
    public JSONObject updateTable(@RequestParam Map<String,Object>map)
    {
        JSONObject response= JSONObject.parseObject(map.get("data").toString());
        JSONObject obj=new JSONObject();
        obj.put("table",wordService.updateWordTable((int)response.get("wid"), response.get("word_name").toString(),
                (int)response.get("word_type"),(int)response.get("word_level"),(int)response.get("word_way")));
        obj.put("state",2000);
        obj.put("message","成功");
        return obj;
    }
    @PostMapping("add")
    public JSONObject addTable(@RequestParam Map<String,Object>map)
    {
        JSONObject response= JSONObject.parseObject(map.get("data").toString());
        JSONObject obj=new JSONObject();
        obj.put("table",wordService.addWord( response.get("word_name").toString(),
                (int)response.get("word_type"),(int)response.get("word_level"),(int)response.get("word_way")));
        obj.put("state",2000);
        obj.put("message","成功");
        return obj;
    }
    @PostMapping("delete")
    public  JSONObject deleteTable(@RequestParam Integer id)
    {
        JSONObject obj=new JSONObject();
        obj.put("state",wordService.deleteByWid(new Integer[]{id}));
        obj.put("message","成功");
        return obj;
    }
    @PostMapping("search")
    public JSONObject searchFromTable(@RequestParam("page")Integer PageId,@RequestParam ("sensitive") String word_name,
                                      @RequestParam("types")Integer word_type)
    {
        JSONObject obj=new JSONObject();
        if(word_name.equals("")&&word_type==null)return null;
        if(word_name.equals(""))
        {
            List<Word> wordlist=wordService.findByType(PageId,word_type);
            obj.put("table",wordlist);
            obj.put("total",wordService.countByType(word_type));
        }
        else if(word_type==null)
        {
            List<Word> wordlist=wordService.findByWname(word_name);
            obj.put("table",wordlist);
            obj.put("total",wordlist.size());
        }
        else {
            List<Word> wordlist=wordService.findByBoth(1,word_name,word_type);
            obj.put("table",wordlist);
            obj.put("total",wordlist.size());
        }
        obj.put("state",2000);
        obj.put("message","操作成功");
        return obj;
    }
    @PostMapping("deletes")
    public  JSONObject deletesFromTable(@RequestBody Integer[]ids)
    {
        JSONObject obj=new JSONObject();
        obj.put("state",wordService.deleteByWid(ids));
        obj.put("message","操作成功");
        return obj;
    }


}
