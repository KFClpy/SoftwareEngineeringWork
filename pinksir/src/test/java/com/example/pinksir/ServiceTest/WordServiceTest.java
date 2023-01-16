package com.example.pinksir.ServiceTest;

import com.example.pinksir.entity.Word;
import com.example.pinksir.service.WordService;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class WordServiceTest {
    @Autowired
    WordService wordService;
    @Test
    public void addtest()
    {
        List<Word>list= wordService.addWord(1,"123",1,2,3);
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    public void deletetest()
    {
        List<Word>list=wordService.deleteByWid(1,5);
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    public void updatetest()
    {
        List<Word>list=wordService.updateWordTable(1,7,"test",3,4,5);
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    public void findtest()
    {
        List<Word>list=wordService.getWordTable(1);
        List<Word>list2=wordService.findByType(1,5);
        List<Word>list3=wordService.findByWname("test");
        System.out.println(Arrays.toString(list3.toArray()));
    }
    @Test
    public void counttest()
    {
        Integer num1=wordService.countAll();
        Integer num2=wordService.countByType(3);
        System.out.println(num1+" "+num2);
    }
}
