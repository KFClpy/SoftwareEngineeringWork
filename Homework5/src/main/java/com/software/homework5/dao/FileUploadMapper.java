package com.software.homework5.dao;

import com.software.homework5.entity.FileUpLoad;

public interface FileUploadMapper {
    Integer insert(FileUpLoad fileUpLoad);
    FileUpLoad selectByid(int id);
}

