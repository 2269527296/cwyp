package com.abc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wzx
 * @version 1.0
 * @mailbox cw_yp@qq.com
 */
@RestController
@RequestMapping("test")
public class redistest {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String test(){
        redisTemplate.opsForValue().set("name","zhangsan");
        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }
}
