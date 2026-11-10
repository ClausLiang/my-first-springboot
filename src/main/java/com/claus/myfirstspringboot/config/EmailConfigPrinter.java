package com.claus.myfirstspringboot.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 该注解表示让spring管理这个类
@Component
public class EmailConfigPrinter {

    @Value("${email.user}")
    private String emailUser;

    @Value("${email.host}")
    private String emailHost;

    @PostConstruct
    // 该注解表示 Spring 创建好这个对象、并注入两个配置值之后，调用这个方法一次
    public void printConfig() {
        System.out.println("email.user=" + emailUser);
        System.out.println("email.host=" + emailHost);
    }
}
