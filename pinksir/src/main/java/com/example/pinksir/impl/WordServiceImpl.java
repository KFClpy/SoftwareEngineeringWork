package com.example.pinksir.impl;

import com.example.pinksir.dao.WordMapper;
import com.example.pinksir.entity.Word;
import com.example.pinksir.ex.DeleteException;
import com.example.pinksir.ex.InsertException;
import com.example.pinksir.ex.UpdateException;
import com.example.pinksir.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WordServiceImpl implements WordService {
    @Autowired
    WordMapper wordMapper;
    @Override
    public List<Word> addWord(Integer PageId, String word_name, Integer word_type, Integer word_level, Integer word_way) {
        Word word=new Word();
        word.setWord_way(word_way);
        word.setWord_level(word_level);
        word.setWord_name(word_name);
        word.setWord_type(word_type);
        Integer rows=wordMapper.insert(word);
        if(rows!=1)
        {
            throw new InsertException("插入时错误");
        }
        return getWordTable(PageId);
    }

    @Override
    public List<Word> getWordTable(Integer PageId) {
        return wordMapper.findByPage(PageId);
    }

    @Override
    public List<Word> findByWname(String word_name) {
        return wordMapper.findByName(1,word_name);
    }

    @Override
    public List<Word> findByType(Integer PageId, Integer word_type) {
        return wordMapper.findByType(PageId,word_type);
    }

    @Override
    public List<Word> updateWordTable(Integer PageId, Integer wid, String word_name, Integer word_type, Integer word_level, Integer word_way) {
        Integer rows=wordMapper.updateByWid(wid,word_name,word_type,word_level,word_way);
        if(rows!=1)
        {
            throw new UpdateException("更新时错误");
        }
        return getWordTable(PageId);
    }

    @Override
    public List<Word> deleteByWid(Integer PageId, Integer []wid) {
        int rows=0;
        for(Integer id:wid)
        {
            rows+=wordMapper.deleteByWid(id);
        }
        if(rows!=wid.length)
        {
            throw new DeleteException("删除信息时错误");
        }
        return getWordTable(PageId);
    }

    @Override
    public Integer countAll() {
        return wordMapper.countAllWord();
    }

    @Override
    public Integer countByType(Integer word_type) {
        return wordMapper.countWordByType(word_type);
    }

    @Override
    public List<String> getAllWord() {
        return wordMapper.findAllWord();
    }
}
