package com.example.java25demo.testcontainers;

import com.example.java25demo.MyRedisService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@Import(TestContainersConfiguration.class)
@SpringBootTest
public class MySpringTest {
    @Autowired
    MyRedisService service;

    @Test
    public void testSomething() {
        service.setKeyValue("mike", "test1234");
        System.out.println(service.getValue("mike"));
        Assertions.assertThat(service.getValue("mike")).isNotEmpty();
        Assertions.assertThat(service.getValue("mike")).get().isEqualTo("test1234");
        Assertions.assertThat(service.getValue("sadfsadf")).isEmpty();
    }
}
