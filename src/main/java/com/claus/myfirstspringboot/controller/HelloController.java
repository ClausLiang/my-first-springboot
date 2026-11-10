package com.claus.myfirstspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    // 第一种方式读取配置
    @Value("${email.user}")
    private String emailUser;

    @Value("${email.host}")
    private String emailHost;

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return "hello " + name;
    }

    @GetMapping("/getProperties")
    public Map<String, String> getProperties() {
        return Map.of("email.user", emailUser, "email.host", emailHost);
    }
}
