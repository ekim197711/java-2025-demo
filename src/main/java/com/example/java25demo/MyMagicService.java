package com.example.java25demo;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class MyMagicService {
    public String getMessage(@NonNull String key) {
        var myMap = Map.of("name", "Mike", "age", 20);
        return myMap.getOrDefault(key, "unknown").toString();
    }
}