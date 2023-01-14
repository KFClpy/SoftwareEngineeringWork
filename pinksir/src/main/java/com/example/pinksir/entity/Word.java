package com.example.pinksir.entity;

import java.util.Objects;

public class Word {
    private Integer wid;
    private String word_name;
    private Integer word_type;
    private Integer word_level;
    private Integer word_way;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWord_name() {
        return word_name;
    }

    public void setWord_name(String word_name) {
        this.word_name = word_name;
    }

    public Integer getWord_type() {
        return word_type;
    }

    public void setWord_type(Integer word_type) {
        this.word_type = word_type;
    }

    public Integer getWord_level() {
        return word_level;
    }

    public void setWord_level(Integer word_level) {
        this.word_level = word_level;
    }

    public Integer getWord_way() {
        return word_way;
    }

    public void setWord_way(Integer word_way) {
        this.word_way = word_way;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return wid.equals(word.wid) && word_name.equals(word.word_name) && word_type.equals(word.word_type) && word_level.equals(word.word_level) && word_way.equals(word.word_way);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wid, word_name, word_type, word_level, word_way);
    }

    @Override
    public String toString() {
        return "Word{" +
                "wid=" + wid +
                ", word_name='" + word_name + '\'' +
                ", word_type=" + word_type +
                ", word_level=" + word_level +
                ", word_way=" + word_way +
                '}';
    }
}
