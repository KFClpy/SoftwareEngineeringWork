package com.example.pinksir.entity;

import java.util.Objects;

public class Group {
    private String group_num;
    private String group_content;


    public String getGroup_num() {
        return group_num;
    }

    public void setGroup_num(String group_num) {
        this.group_num = group_num;
    }

    public String getGroup_content() {
        return group_content;
    }

    public void setGroup_content(String group_content) {
        this.group_content = group_content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return group_num.equals(group.group_num) && group_content.equals(group.group_content);
    }

    @Override
    public String toString() {
        return "Group{" +
                "group_num=" + group_num +
                ", group_content='" + group_content + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(group_num, group_content);
    }
}
