package com.example.pinksir.ServiceTest;

import com.example.pinksir.service.QuserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest

public class QuserServiceTest {
    @Autowired
    QuserService quserService;
    @Test
    public void updateTest()
    {
        System.out.println(quserService.updateQuserTable("ok","1111111",
                "2291897613",0,Date.valueOf("2018-2-2"),"OK"));

    }
    @Test
    public void findTest()
    {
        System.out.println(quserService.findQuserByNum(1,"1111111","2291897613"));
    }
    @Test
    public void deleteTest()
    {
        System.out.println(quserService.delelteAll("1111111"));
    }
    @Test
    public void countAllTest()
    {
        System.out.println(quserService.countAllTable("1111111"));
    }
    @Test
    public void AlltableTest()
    {
        System.out.println(quserService.getQuserTable(1,"441327221"));
    }
}
