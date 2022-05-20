package com.software.homework5.Dao;

import com.software.homework5.Entity.Award;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AwardMapper {
    Integer insert(Award award);
    List<Award>findByUserName(String username);
    Integer delete(Integer aid);
    Integer updateByAid(
            @Param("aid") Integer aid,
            @Param("aname") String aname,
            @Param("num") Integer num,
            @Param("intro") String intro,
            @Param("img") String img
    );
    List<Award>findByAname(@Param("username") String username,@Param("aname") String aname);
    Integer updateEmptyByAid(
            @Param("aid") Integer aid,
            @Param("empty") Integer empty
    );
}
