package com.software.homework5.Controller;

import com.software.homework5.Util.RedisUtils;
import com.software.homework5.Util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("info")
@RestController
public class InfoController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtils tokenUtils;
}
