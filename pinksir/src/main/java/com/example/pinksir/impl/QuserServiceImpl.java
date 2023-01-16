package com.example.pinksir.impl;

import com.example.pinksir.dao.UserMapper;
import com.example.pinksir.entity.Quser;
import com.example.pinksir.ex.UpdateException;
import com.example.pinksir.service.QuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class QuserServiceImpl implements QuserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Quser> getQuserTable(Integer PageId, String group_num) {
        return userMapper.findByPage(group_num,PageId);
    }

    @Override
    public List<Quser> findQuserByNum(Integer PageId, String group_num, String unum) {
        return userMapper.findByNum(unum,group_num,PageId);
    }

    @Override
    public List<Quser> updateQuserTable(Integer PageId, String uname, String group_num, String unum, Integer ban_num, Date ban_date, String umemo) {
        Quser quser=new Quser();
        quser.setBan_num(ban_num);
        quser.setUname(uname);
        quser.setBan_date(ban_date);
        quser.setUnum(unum);
        quser.setGroup_num(group_num);
        quser.setUmemo(umemo);
        int rows= userMapper.updateQuser(quser);
        if(rows==0){
            throw new UpdateException("更新时错误");
        }
        return getQuserTable(PageId,group_num);
    }

    @Override
    public Integer countAllTable(String group_num) {
        return userMapper.countAll(group_num);
    }

    @Override
    public List<Quser> delelteAll(Integer PageId,String group_num) {
        Integer rows=userMapper.deleteByGroupNum(group_num);
        if(rows==0)
        {
            throw new UpdateException("删除时错误");
        }
        return getQuserTable(PageId,group_num);
    }
}
