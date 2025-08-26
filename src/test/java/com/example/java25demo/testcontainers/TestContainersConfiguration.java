package com.example.java25demo.testcontainers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.GenericContainer;

import java.util.List;

@TestConfiguration(proxyBeanMethods = false)
@ImportTestcontainers(TestContainersDefinition.class)
@Configuration
public class TestContainersConfiguration {

    @Bean
    public GenericContainer redisContainer(GenericContainer redisContainer) {
        redisContainer.setPortBindings(List.of("6379:6379"));
        return redisContainer;
    }
}
