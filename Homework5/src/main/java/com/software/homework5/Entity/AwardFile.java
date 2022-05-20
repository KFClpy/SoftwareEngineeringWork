package com.software.homework5.Entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class AwardFile {
    private Integer aid;
    private String aname;
    private Integer num;
    private String intro;
    private MultipartFile file;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwardFile awardFile = (AwardFile) o;
        return Objects.equals(aid, awardFile.aid) && Objects.equals(aname, awardFile.aname) && Objects.equals(num, awardFile.num) && Objects.equals(intro, awardFile.intro) && Objects.equals(file, awardFile.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, aname, num, intro, file);
    }

    @Override
    public String toString() {
        return "AwardFile{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", num=" + num +
                ", intro='" + intro + '\'' +
                ", file=" + file +
                '}';
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
