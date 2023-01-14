package com.example.pinksir.dao;

import com.example.pinksir.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper {
    Integer insert(Group group);
    List<Group> findByNum(@Param("group_num")String group_num,@Param("PageId") Integer PageId);
    List<Group> findByPage(Integer PageId);
    Integer countAllGroup();
}
