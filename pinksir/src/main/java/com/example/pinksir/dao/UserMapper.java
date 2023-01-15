package com.example.pinksir.dao;

import com.example.pinksir.entity.Quser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer updateQuser(Quser quser);
}
