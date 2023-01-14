package com.example.pinksir.dao;

import com.example.pinksir.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordMapper {
    Integer insert(Word word);
    List<Word>findByPage(Integer PageId);
    List<Word>findByName(@Param("PageId") Integer PageId, @Param("word_name")String word_name);
    List<Word>findByType(@Param("PageId") Integer PageId,@Param("word_type")Integer word_type);
    List<String>findAllWord();
    Integer countAllWord();
    Integer countWordByType(Integer word_type);
}
