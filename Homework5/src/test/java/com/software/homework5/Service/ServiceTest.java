package com.software.homework5.Service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    InfoService infoService;

    @Test
    public void getInfoTest()
    {
        JSONObject obj=infoService.getInfoTable(7);
        System.out.println(obj);
    }
    @Test
    public void searchInfoTest()
    {
        JSONObject obj=infoService.searchInfo(16,8);
        System.out.println(obj);
    }
    @Test
    public void deleteInfoTest()
    {
        JSONObject obj=infoService.deleteInfo(16,7);
        System.out.println(obj);
    }
    @Test
    public void addInfoTest()
    {
        JSONObject obj=infoService.addInfo(7,"刘洋",0,"1384013213","22972@qq.com");
        System.out.println(obj);
    }
}
