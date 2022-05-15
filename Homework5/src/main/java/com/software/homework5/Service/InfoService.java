package com.software.homework5.Service;

import com.alibaba.fastjson.JSONObject;

public interface InfoService {
    JSONObject getInfoTable(Integer uid);
    JSONObject updateInfo(Integer mid,Integer uid,String name,Integer render,String phone,String email);
    JSONObject addInfo(Integer uid,String name,Integer render,String phone,String email);
    JSONObject deleteInfo(Integer mid,Integer uid);
    JSONObject searchInfo(Integer mid,Integer uid);
}
