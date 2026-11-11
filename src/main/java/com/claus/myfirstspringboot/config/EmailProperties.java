package com.claus.myfirstspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
// 将配置批量绑定到一个类
@ConfigurationProperties(prefix = "email")
// 本项目通过入口类上的 @ConfigurationPropertiesScan 注册这个配置类
// 对当前这种带 setter 的类，也可以改用 @Component 注册
public class EmailProperties {

    private String user;
    private String host;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
