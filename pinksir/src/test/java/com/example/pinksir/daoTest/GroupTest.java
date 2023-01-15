package com.example.pinksir.daoTest;

import com.example.pinksir.dao.GroupMapper;
import com.example.pinksir.entity.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest

public class GroupTest {
    @Autowired
    GroupMapper groupMapper;
    @Test
    public void insertTest()
    {
        Group group=new Group();
        group.setGroup_num("1162806685");
        group.setGroup_content("wocaonima");
        Integer num=groupMapper.insert(group);
        System.out.println(num);
    }
    @Test
    public void test()
    {
        List<Group>list=groupMapper.findByPage(2);
        List<Group>list2=groupMapper.findByNum("1162806685",1);
        Integer num=groupMapper.countAllGroup();
        System.out.println(num);
        System.out.println(Arrays.toString(list2.toArray()));
    }
    @Test
    public void updatetest()
    {
        Integer num= groupMapper.updateByNum("2291897613","傻逼东西");
        System.out.println(num);
    }
    @Test
    public void deletetest()
    {
        Integer num=groupMapper.deleteByNum("2291897613");
        System.out.println(num);
    }
}
