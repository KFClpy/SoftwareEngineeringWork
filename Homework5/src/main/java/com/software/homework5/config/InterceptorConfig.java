package com.software.homework5.config;

import com.software.homework5.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /*    private TokenInterceptor tokenInterceptor;
    //构造方法
    public InterceptorConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor =tokenInterceptor;
    }*/
    @Autowired
    private AuthenticationInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/users/login");//登录
        excludePath.add("/users/reg");//注册
        excludePath.add("/static/**");  //静态资源
        registry
                .addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        // WebMvcConfigurer.super.addInterceptors(registry);
    }
}