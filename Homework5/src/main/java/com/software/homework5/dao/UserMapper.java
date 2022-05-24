package com.software.homework5.dao;

import com.software.homework5.entity.User;
import org.apache.ibatis.annotations.Param;


import java.util.Date;

public interface UserMapper {
    Integer insert(User user);
    User findByUsername(String username);
    Integer updatePasswordByUid(
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime
    );
    User findByUid(Integer uid);
    Integer updateAvatarByUid(
            @Param("avatar")String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime
    );
    Integer updateAllByUsername(
            @Param("nickname")String nickname,
            @Param("phone")String phone,
            @Param("gender")Integer gender,
            @Param("identity")Integer identity,
            @Param("email")String email,
            @Param("modifiedUser")String modifiedUser,
            @Param("modifiedTime")Date modifiedTime
    );
}