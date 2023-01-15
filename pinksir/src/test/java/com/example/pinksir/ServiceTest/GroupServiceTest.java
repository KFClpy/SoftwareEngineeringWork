package com.example.pinksir.ServiceTest;

import com.example.pinksir.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class GroupServiceTest {
    @Autowired
    GroupService groupService;
    @Test
    public void test()
    {
//        System.out.println(Arrays.toString(groupService.getGroupTable(1).toArray()));
//        System.out.println(Arrays.toString(groupService.addGroup(1,"249196","sb").toArray()));
//        System.out.println(Arrays.toString(groupService.updateGroupTable(1, "249196", "345").toArray()));
//        String[] group_nums ={"2491967","249196","1162806685"};
//        System.out.println(Arrays.toString(groupService.deleteGroupTable(1,group_nums).toArray()));
        System.out.println(Arrays.toString(groupService.findGroup("249196").toArray()));
    }
}
