package com.software.homework5.Service;

import com.alibaba.fastjson.JSONObject;
import com.software.homework5.Entity.Info;

import java.util.List;

public interface InfoService {
    List<Info> getInfoTable(String username);
    List<Info> updateInfo(Integer mid,String username,String name,Integer render,String phone,String email);
    List<Info> addInfo(String username,String name,Integer render,String phone,String email);
    List<Info> deleteInfo(Integer mid,String username);
    List<Info> searchInfo(Integer mid,String username);
}
