package com.example.java25demo.testcontainers;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

interface TestContainersDefinition {
    @Container
    GenericContainer redisContainer = new GenericContainer<>(DockerImageName.parse("redis:8-alpine"));
}
