package com.example.pinksir.runner;

import com.example.pinksir.wordfilter.WordFilterUtil;
import com.example.pinksir.wordfilter.XEyes;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component  //将类交给springboot容器处理
@Order(1)
public class InitialCache implements ApplicationRunner {
    private static XEyes ge;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ge=new WordFilterUtil().getGoldenEyes();
    }
    public static XEyes getGe()
    {
        return ge;
    }
}
