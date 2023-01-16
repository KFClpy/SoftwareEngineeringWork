package com.example.pinksir.ServiceTest;

import com.example.pinksir.service.FilterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class FilterServiceTest {
    @Autowired
    FilterService filterService;
    @Test
    public void test()
    {
        System.out.println(filterService.isExist("249196"));
    }
    @Test
    public void invalidTest()
    {
        System.out.println(filterService.isInvalid("新思想"));
    }
}
