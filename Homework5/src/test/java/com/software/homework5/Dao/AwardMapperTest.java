package com.software.homework5.Dao;

import com.software.homework5.Entity.Award;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AwardMapperTest {
    @Autowired
    AwardMapper awardMapper;
    @Test
    public void insertTest()
    {
        Award award=new Award();
        award.setAname("kfc1");
        award.setUsername("lty123456");
        award.setImg("test");
        award.setNum(50);
        award.setIntro("testintro");
        Integer rows=awardMapper.insert(award);
        System.out.println(rows);
    }
    @Test
    public void deleteTest()
    {
        Integer rows=awardMapper.delete(53);
        System.out.println(rows);
    }
    @Test
    public void updateTest()
    {
        awardMapper.updateByAid(54,"test1",0,"abc","testnow");
    }
    @Test
    public void selectTest(){
        List<Award>list=awardMapper.findByUserName("lty123456");
        System.out.println(list);
    }
    @Test
    public void selectTest2()
    {
        List<Award>list=awardMapper.findByAname("lty123456","test1");
        System.out.println(list);
    }
    @Test
    public void EmptyTest()
    {
        awardMapper.updateEmptyByAid(55,1);
        awardMapper.updateAllEmptyByAid();
    }
}
