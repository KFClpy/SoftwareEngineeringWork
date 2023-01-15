package com.example.pinksir.impl;

import com.example.pinksir.dao.GroupMapper;
import com.example.pinksir.entity.Group;
import com.example.pinksir.ex.DeleteException;
import com.example.pinksir.ex.InsertException;
import com.example.pinksir.ex.UpdateException;
import com.example.pinksir.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Override
    public List<Group> getGroupTable(Integer PageId) {
        return groupMapper.findByPage(PageId);
    }

    @Override
    public Integer countGroupTable() {
        return groupMapper.countAllGroup();
    }

    @Override
    public List<Group> deleteGroupTable(Integer PageId,String[] group_nums) {
        int rows=0;
        for(String group_num:group_nums)
        {
            rows+=groupMapper.deleteByNum(group_num);
        }
        if(rows!=group_nums.length)
        {
            throw new DeleteException("删除信息时错误");
        }
        return getGroupTable(PageId);
    }

    @Override
    public List<Group> updateGroupTable(Integer PageId, String group_num, String group_content) {
        int rows=groupMapper.updateByNum(group_num,group_content);
        if(rows!=1)
        {
            throw new UpdateException("更新信息时错误");
        }
        return getGroupTable(PageId);
    }

    @Override
    public List<Group> addGroup(Integer PageId, String group_num, String group_content) {
        Group group=new Group();
        group.setGroup_num(group_num);
        group.setGroup_content(group_content);
        int rows=groupMapper.insert(group);
        if(rows!=1)
        {
            throw new InsertException("插入信息时错误");
        }
        return getGroupTable(PageId);
    }

    @Override
    public List<Group> findGroup(String group_num) {
        return groupMapper.findByNum(group_num,1);
    }
}
