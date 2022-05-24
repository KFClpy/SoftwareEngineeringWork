package com.software.homework5.service;

import com.software.homework5.entity.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    InfoService infoService;

    @Test
    public void getInfoTest()
    {
        List<Info> list=infoService.getInfoTable("7");
        System.out.println(list);
    }
    @Test
    public void searchInfoTest()
    {
        List<Info> list=infoService.searchInfo("刘洋","7");
        System.out.println(list);
    }
    @Test
    public void addInfoTest()
    {
        List<Info> list=infoService.addInfo("lty","刘洋",0,"1384013213","22972@qq.com");
        System.out.println(list);
    }
}
