package com.example.pinksir.service;

import com.example.pinksir.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group>getGroupTable(Integer PageId);
    Integer countGroupTable();
    List<Group>deleteGroupTable(Integer PageId,String[] group_nums);

    List<Group>updateGroupTable(Integer PageId,String group_num,String group_content);
    List<Group>addGroup(Integer PageId,String group_num,String group_content);
    List<Group>findGroup(String group_num);
}
