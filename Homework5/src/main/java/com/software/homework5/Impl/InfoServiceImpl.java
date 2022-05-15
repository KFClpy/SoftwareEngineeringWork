package com.software.homework5.Impl;

import com.alibaba.fastjson.JSONObject;
import com.software.homework5.Dao.InfoMapper;
import com.software.homework5.EX.InsertException;
import com.software.homework5.EX.UpdateException;
import com.software.homework5.Entity.Info;
import com.software.homework5.Service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer rows=infoMapper.updateByMid(mid,name,render,phone,email);
        if(rows!=1)
        {
            throw new UpdateException("更新信息失败");
        }
        return getInfoTable(uid);
    }
    public JSONObject addInfo(Integer uid,String name,Integer render,String phone,String email)
    {
       Info info=new Info();
       info.setName(name);
       info.setGender(render);
       info.setPhone(phone);
       info.setEmail(email);
       info.setUid(uid);
       Integer rows=infoMapper.insert(info);
       if(rows!=1)
       {
           throw new InsertException("插入失败，发生未知错误");
       }
       return getInfoTable(uid);
    }
    public JSONObject deleteInfo(Integer mid,Integer uid)
    {
        JSONObject obj=new JSONObject();
        Integer rows=infoMapper.delete(mid);
        if(rows!=1)
        {
            throw new UpdateException("删除信息失败");
        }
        return getInfoTable(uid);
    }
    public JSONObject searchInfo(Integer mid,Integer uid)
    {
        JSONObject obj=new JSONObject();
        List<Info>list=infoMapper.findByMid(uid,mid);
        obj.put("InfoTable",list);
        return obj;
    }
}
