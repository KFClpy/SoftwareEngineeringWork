package com.software.homework5.service;

import com.software.homework5.entity.Info;

import java.util.List;

public interface InfoService {
    List<Info> getInfoTable(String username);
    List<Info> updateInfo(Integer mid, String username, String name, Integer render, String phone, String email);
    List<Info> addInfo(String username,String name,Integer render,String phone,String email);
    List<Info> deleteInfo(Integer []mid,String username);
    List<Info> searchInfo(String name,String username);
    Info searchSingle(Integer mid);
}
