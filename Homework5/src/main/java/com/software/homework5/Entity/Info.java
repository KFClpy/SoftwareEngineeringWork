package com.software.homework5.Entity;

import java.util.Objects;

public class Info {
    private Integer mid;
    private String name;
    private Integer gender;
    private String phone;
    private String email;
    private Integer uid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return mid.equals(info.mid) && name.equals(info.name) && gender.equals(info.gender) && phone.equals(info.phone) && email.equals(info.email) && uid.equals(info.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid);
    }

    @Override
    public String toString() {
        return "Info{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", uid=" + uid +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
