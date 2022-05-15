package com.software.homework5.Dao;

import com.software.homework5.Entity.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    Integer insert(Info info);
    List<Info> findByUid(Integer uid);
    Integer delete(Integer mid);
    Integer updateByMid(
            @Param("mid") Integer mid,
            @Param("name") String name,
            @Param("gender") Integer gender,
            @Param("phone") String phone,
            @Param("email") String email
    );
    List<Info> findByMid(Integer uid,Integer mid);
}
