package com.software.homework5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.software.homework5.Dao")
public class Homework5Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework5Application.class, args);
    }

}
