package com.software.homework5.Impl;

import com.alibaba.fastjson.JSONObject;
import com.software.homework5.Dao.InfoMapper;
import com.software.homework5.Entity.Info;
import com.software.homework5.Service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoMapper infoMapper;
    public JSONObject getInfoTable(Integer uid)
    {
        JSONObject obj=new JSONObject();
        List<Info> list=infoMapper.findByUid(uid);
        obj.put("InfoTable",list);
        return obj;
    }
    public JSONObject updateInfo(Integer mid,Integer uid,String name,Integer render,String phone,String email)
    {
        JSONObject obj=new JSONObject();
        infoMapper.updateByMid(mid,name,render,phone,email);
        List<Info>list=infoMapper.findByUid(uid);
        obj.put("InfoTable",list);
        return obj;
    }
    public JSONObject addInfo(Integer uid,String name,Integer render,String phone,String email)
    {
       JSONObject obj=new JSONObject();
       Info info=new Info();
       info.setName(name);
       info.setGender(render);
       info.setPhone(phone);
       info.setEmail(email);
       info.setUid(uid);
       infoMapper.insert(info);
       List<Info>list=infoMapper.findByUid(uid);
       obj.put("InfoTable",list);
       return obj;
    }
    public JSONObject deleteInfo(Integer mid,Integer uid)
    {
        JSONObject obj=new JSONObject();
        infoMapper.delete(mid);
        List<Info>list=infoMapper.findByUid(uid);
        obj.put("InfoTable",list);
        return obj;
    }
    public JSONObject searchInfo(Integer mid,Integer uid)
    {
        JSONObject obj=new JSONObject();
        List<Info>list=infoMapper.findByMid(uid,mid);
        obj.put("InfoTable",list);
        return obj;
    }
}
