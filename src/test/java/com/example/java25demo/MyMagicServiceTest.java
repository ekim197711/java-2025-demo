package com.example.java25demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMagicServiceTest {

    public static final String HEIGHT = "height";
    @Autowired
    private MyMagicService myMagicService;

    @Test
    void getValue() {
        var message = myMagicService.getMessage(null);
        Assertions.assertThat(message).isEqualTo("unknown");

        var message2 = myMagicService.getMessage("name");
        Assertions.assertThat(message2).isEqualTo("Mike");
    }
}