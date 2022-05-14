package com.software.homework5.Dao;

import com.software.homework5.Entity.FileUpLoad;

public interface FileUploadMapper {
    Integer insert(FileUpLoad fileUpLoad);
    FileUpLoad selectByid(int id);
}

