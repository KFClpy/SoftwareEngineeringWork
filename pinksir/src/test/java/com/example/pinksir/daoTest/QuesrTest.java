package com.example.pinksir.daoTest;

import com.example.pinksir.dao.UserMapper;
import com.example.pinksir.entity.Quser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class QuesrTest{
    @Autowired
    UserMapper userMapper;
    @Test
    public void updateTest()
    {
        Quser quser=new Quser();
        quser.setUnum("2291897613");
        quser.setGroup_num("111111");
        quser.setUname("ok");
        String str="2018-2-3";
        quser.setBan_date(Date.valueOf(str));
        quser.setBan_num(0);
        Integer num=userMapper.updateQuser(quser);
        System.out.println(num);
    }
}
