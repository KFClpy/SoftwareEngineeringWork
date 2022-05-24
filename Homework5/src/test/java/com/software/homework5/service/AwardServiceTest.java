package com.software.homework5.service;

import com.software.homework5.entity.Award;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AwardServiceTest {
    @Autowired
    AwardService awardService;
    @Test
    public void getAwardTest()
    {
        List<Award>list=awardService.getAwardTable("lty123456");
        System.out.println(list);
    }
}
