package com.software.homework5.service;

import com.alibaba.fastjson.JSONObject;
import com.software.homework5.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    void reg(User user);
    User login(String username, String password);
    void changePassword(String username,String oldPassword,String newPassword);
    void updateAvatar(String username, MultipartFile file);
    void updateInfo(String username,String nickname,String phone,Integer gender,Integer identity,String email);
    JSONObject getUserInfo(String username);
}