package com.example.pinksir.entity;

import java.sql.Date;
import java.util.Objects;

public class Quser {
    private Integer uid;
    private String uname;
    private Integer group_num;
    private Integer unum;
    private Integer ban_num;
    private Date ban_date;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getGroup_num() {
        return group_num;
    }

    public void setGroup_num(Integer group_num) {
        this.group_num = group_num;
    }

    public Integer getUnum() {
        return unum;
    }

    public void setUnum(Integer unum) {
        this.unum = unum;
    }

    public Integer getBan_num() {
        return ban_num;
    }

    public void setBan_num(Integer ban_num) {
        this.ban_num = ban_num;
    }

    public Date getBan_date() {
        return ban_date;
    }

    public void setBan_date(Date ban_date) {
        this.ban_date = ban_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quser quser = (Quser) o;
        return uid.equals(quser.uid) && uname.equals(quser.uname) && group_num.equals(quser.group_num) && unum.equals(quser.unum) && ban_num.equals(quser.ban_num) && ban_date.equals(quser.ban_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, group_num, unum, ban_num, ban_date);
    }

    @Override
    public String toString() {
        return "Quser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", group_num=" + group_num +
                ", unum=" + unum +
                ", ban_num=" + ban_num +
                ", ban_date=" + ban_date +
                '}';
    }
}
