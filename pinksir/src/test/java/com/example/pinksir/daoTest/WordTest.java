package com.example.pinksir.daoTest;

import com.example.pinksir.dao.WordMapper;
import com.example.pinksir.entity.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WordTest {
    @Autowired
    WordMapper wordMapper;
    @Test
    public void insertTest()
    {
        Word word=new Word();
        word.setWord_level(2);
        word.setWord_name("操你妈");
        word.setWord_type(2);
        word.setWord_way(2);
        Integer i=wordMapper.insert(word);
        System.out.println(i);
    }
    @Test
    public void selectTest()
    {
        List<Word> list=wordMapper.findByPage(1);
        for(Word word:list) System.out.println(word);
    }
    @Test
    public void selectByNameTest()
    {
        List<Word>list=wordMapper.findByName(1,"操你妈");
        for(Word word :list) System.out.println(word);
    }
    @Test
    public void selectByType() {
        List<Word> list = wordMapper.findByType(1, 1);
        for (Word word : list) System.out.println(word);
    }
    @Test
    public void selectAllWord()
    {
        List<String>list=wordMapper.findAllWord();
        for(String str:list) System.out.println(str);
    }
    @Test
    public void countAllWord()
    {
        Integer num=wordMapper.countAllWord();
        System.out.println(num);
    }
    @Test
    public void countByType()
    {
        Integer num=wordMapper.countWordByType(1);
        System.out.println(num);
    }
    @Test
    public void updateTest()
    {
        Integer num=wordMapper.updateByWid(6,"123",1,1,1);
    }
    @Test
    public void deleteTest()
    {
        Integer num= wordMapper.deleteByWid(6);
        System.out.println(num);
    }
}
