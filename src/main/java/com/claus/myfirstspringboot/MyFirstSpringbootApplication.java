package com.claus.myfirstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
// 以下这个注解是为了去发现@ConfigurationProperties，因为我的那个类没加@Component
@ConfigurationPropertiesScan
public class MyFirstSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringbootApplication.class, args);
    }

}
