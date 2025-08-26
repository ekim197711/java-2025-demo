package com.example.java25demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMagicServiceTest {

    @Autowired
    private MyMagicService myMagicService;

    @Test
    void getValue() {
        var message = myMagicService.getMessage("World");
        Assertions.assertThat(message).isEqualTo("Hello, World!");
    }
}