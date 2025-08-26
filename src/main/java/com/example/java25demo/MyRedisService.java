package com.example.java25demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyRedisService {
    private final Jedis jedis;

    public void setKeyValue(String key, String value) {
        jedis.set(key, value);
    }

    public Optional<String> getValue(String key) {
        return Optional.ofNullable(jedis.get(key));
    }
}
