package com.example.pinksir.runner;

import com.example.pinksir.service.WordService;
import com.example.pinksir.wordfilter.WordFilterUtil;
import com.example.pinksir.wordfilter.XEyes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  //将类交给springboot容器处理
@Order(1)
public class InitialCache implements ApplicationRunner {
    private static XEyes ge;
    @Autowired
    WordService wordService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ge=new WordFilterUtil().getGoldenEyes(wordService.getAllWord());
    }
    public static XEyes getGe()
    {
        return ge;
    }
    public static void setGe(List<String> list){
        ge=new WordFilterUtil().getGoldenEyes(list);
    }
}
