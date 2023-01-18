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

    }
    @Test
    public void deletetest()
    {
        Integer num=wordService.deleteByWid(new Integer[]{7,8,9,10,11,13});
        System.out.println(num);
    }
    @Test
    public void updatetest()
    {

    }
    @Test
    public void findtest()
    {
        List<Word>list=wordService.getWordTable(1);
        List<Word>list2=wordService.findByType(1,5);
        List<Word>list3=wordService.findByWname("test");
        List<String>list4=wordService.getAllWord();
        System.out.println(Arrays.toString(list4.toArray()));
    }
    @Test
    public void counttest()
    {
        Integer num1=wordService.countAll();
        Integer num2=wordService.countByType(3);
        System.out.println(num1+" "+num2);
    }
}
