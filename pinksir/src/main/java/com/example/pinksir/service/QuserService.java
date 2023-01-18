package com.example.pinksir.service;

import com.example.pinksir.entity.Quser;

import java.sql.Date;
import java.util.List;

public interface QuserService {
    List<Quser> getQuserTable(Integer PageId,String group_num);
    List<Quser> findQuserByNum(Integer PageId,String group_num,String unum);
    Integer updateQuserTable(String uname, String group_num,
                                 String unum, Integer ban_num, Date ban_date,String umemo);
    Integer countAllTable(String group_num);
    Integer delelteAll(String group_num);
}
