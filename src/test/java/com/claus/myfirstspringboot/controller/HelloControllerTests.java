package com.claus.myfirstspringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
class HelloControllerTests {

    @Autowired
    private WebApplicationContext context;

    @Test
    void helloReturnsHelloWorld() throws Exception {
        webAppContextSetup(context).build()
                .perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"));
    }

    @Test
    void helloUsesNameFromRequest() throws Exception {
        webAppContextSetup(context).build()
                .perform(get("/hello").param("name", "Claus"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello Claus"));
    }

    @Test
    void getPropertiesReturnsEmailConfiguration() throws Exception {
        webAppContextSetup(context).build()
                .perform(get("/getProperties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['email.user']").value("claus"))
                .andExpect(jsonPath("$['email.host']").value("smtp.qq.com"));
    }
}
