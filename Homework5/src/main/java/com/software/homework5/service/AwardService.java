package com.software.homework5.service;

import com.software.homework5.entity.Award;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AwardService {
    List<Award>getAwardTable(String username);
    List<Award>updateAward(Integer aid,String username,String aname,Integer num,String intro,MultipartFile file);
    List<Award>searchAward(String username,String aname);
    List<Award>deleteAward(Integer []aid,String username);
    List<Award>addAward(String username, String aname, Integer num, String intro, MultipartFile file);
    Award getAward(Integer aid);
}
