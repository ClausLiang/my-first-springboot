package com.claus.myfirstspringboot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = {
        "email.user=test-user",
        "email.host=test.example.com"
})
@ExtendWith(OutputCaptureExtension.class)
class EmailConfigPrinterTests {

    @Autowired
    private EmailConfigPrinter printer;

    @Test
    void printsValuesInjectedFromProperties(CapturedOutput output) {
        printer.printConfig();

        assertThat(output).contains("email.user=test-user");
        assertThat(output).contains("email.host=test.example.com");
    }
}
