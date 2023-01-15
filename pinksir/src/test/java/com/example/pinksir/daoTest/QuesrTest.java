package com.example.pinksir.daoTest;

import com.example.pinksir.dao.UserMapper;
import com.example.pinksir.entity.Quser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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
    @Test
    public void selectTest()
    {
        List<Quser>quser=userMapper.findByPage("111111",1);
        List<Quser>list=userMapper.findByNum("2291897613","111111",1);
        System.out.println(Arrays.toString(quser.toArray()));
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    public void countTest()
    {
        Integer num=userMapper.countAll("111111");
        System.out.println(num);
    }
    @Test
    public void delete()
    {
        Integer num=userMapper.deleteByGroupNum("111111");
        System.out.println(num);
    }
}
