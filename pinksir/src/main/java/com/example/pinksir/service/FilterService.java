package com.example.pinksir.service;

public interface FilterService {
    public boolean isExist(String group_num);
    public boolean isInvalid(String str);
    public String randomReply();
}
