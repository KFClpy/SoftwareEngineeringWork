package com.software.homework5.Entity;

import java.util.Objects;

public class Award {
    private Integer aid;
    private String aname;
    private Integer num;
    private String intro;
    private String img;
    private String username;
    private Integer empty;

    @Override
    public String toString() {
        return "Award{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", num=" + num +
                ", intro='" + intro + '\'' +
                ", img='" + img + '\'' +
                ", username='" + username + '\'' +
                ", empty=" + empty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return Objects.equals(aid, award.aid) && Objects.equals(aname, award.aname) && Objects.equals(num, award.num) && Objects.equals(intro, award.intro) && Objects.equals(img, award.img) && Objects.equals(username, award.username) && Objects.equals(empty, award.empty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid);
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getEmpty() {
        return empty;
    }

    public void setEmpty(Integer empty) {
        this.empty = empty;
    }
}
