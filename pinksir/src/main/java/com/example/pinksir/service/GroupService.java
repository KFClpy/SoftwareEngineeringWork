package com.example.pinksir.service;

import com.example.pinksir.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group>getGroupTable(Integer PageId);
    Integer countGroupTable();
    Integer deleteGroupTable(String[] group_nums);

    Integer updateGroupTable(String group_num,String group_content);
    Integer addGroup(String group_num,String group_content);
    List<Group>findGroup(String group_num);
}
