package com.example.pinksir.dao;

import com.example.pinksir.entity.Quser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer updateQuser(Quser quser);
    List<Quser> findByPage(@Param("group_num") String group_num,@Param("PageId") Integer PageId);
    List<Quser> findByNum(@Param("unum") String unum,@Param("group_num") String group_num,@Param("PageId") Integer PageId);
    Integer countAll(@Param("group_num") String group_num);
    Integer deleteByGroupNum(@Param("group_num") String group_num);
}
