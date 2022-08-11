package com.example.pinksir;

import com.example.pinksir.runner.InitialCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PinksirApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinksirApplication.class, args);
        System.out.println(InitialCache.getGe());
    }

}
