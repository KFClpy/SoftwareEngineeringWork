package com.software.homework5.Entity;

import java.util.Objects;

public class Info {
    private Integer mid;
    private String name;
    private Integer gender;
    private String phone;
    private String email;
    private String username;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(mid, info.mid) && Objects.equals(name, info.name) && Objects.equals(gender, info.gender) && Objects.equals(phone, info.phone) && Objects.equals(email, info.email) && Objects.equals(username, info.username);
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
                ", username='" + username + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
