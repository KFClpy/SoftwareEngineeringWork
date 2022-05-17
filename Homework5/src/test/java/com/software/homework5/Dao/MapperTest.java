package com.software.homework5.Dao;

import com.software.homework5.Entity.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MapperTest {
    @Autowired
    InfoMapper infoMapper;
    @Test
    public void insertTest()
    {
        Info info=new Info();
        info.setName("肇腚");
        info.setEmail("2333333@qq.com");
        info.setGender(0);
        info.setPhone("13308532287");
        info.setUsername("6");
        Integer rows=infoMapper.insert(info);
        System.out.println(rows);
    }
    @Test
    public void updateTest()
    {
        infoMapper.updateByMid(16,"梁P",1,"13308276682","233@QQ.com");
    }
    @Test
    public void deleteTest()
    {
        infoMapper.delete(17);
    }
    @Test
    public void selectTest()
    {
        List<Info>list=infoMapper.findByUserName("7");
        System.out.println(list.toString());
        List<Info> result=infoMapper.findByName("7","刘洋");
        System.out.println(result);
    }
}
