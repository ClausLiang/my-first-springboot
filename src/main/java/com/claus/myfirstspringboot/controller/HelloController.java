package com.claus.myfirstspringboot.controller;

import com.claus.myfirstspringboot.config.EmailProperties;
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

    private final EmailProperties emailProperties;

    // 通过构造方法注入 EmailProperties，并保存对象引用
    public HelloController(EmailProperties emailProperties) {
        this.emailProperties = emailProperties;
    }

    // 第一个接口 hello world
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return "hello " + name;
    }

    // 第一种方式读取配置用@value
    @GetMapping("/getProperties")
    public Map<String, String> getProperties() {
        return Map.of("email.user", emailUser, "email.host", emailHost);
    }

    // 第二种方式读取配置用@ConfigurationProperties(prefix = "email")
    @GetMapping("/getEmailProperties")
    public EmailProperties getEmailProperties() {
        return emailProperties;
    }
}
