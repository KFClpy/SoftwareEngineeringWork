package com.example.pinksir;

import com.example.pinksir.runner.InitialCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PinksirApplication {

    public static void main(String[] args) {
//        System.getProperties().put("socksProxySet","true");
//        System.getProperties().put("socksProxyHost","127.0.0.1");
//        System.getProperties().put("socksProxyPort","10793");
        SpringApplication.run(PinksirApplication.class, args);
        System.out.println(InitialCache.getGe());
    }

}
