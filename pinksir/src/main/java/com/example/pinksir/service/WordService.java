package com.example.pinksir.service;

import com.example.pinksir.entity.Word;

import java.util.List;

public interface WordService {
    public Integer addWord(String word_name,
                             Integer word_type,Integer word_level,Integer word_way);
    public List<Word>getWordTable(Integer PageId);
    public List<Word>findByWname(String word_name);
    public List<Word>findByType(Integer PageId,Integer word_type);
    public List<Word>findByBoth(Integer PageId,String word_name,Integer word_type);
    public Integer updateWordTable(Integer wid,String word_name,
                                     Integer word_type,Integer word_level,Integer word_way);
    public Integer deleteByWid(Integer []wid);
    public Integer countAll();
    public Integer countByType(Integer word_type);
    public List<String>getAllWord();
}
