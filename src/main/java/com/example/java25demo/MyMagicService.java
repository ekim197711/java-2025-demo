package com.example.java25demo;

import ch.qos.logback.core.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class MyMagicService {

    public @NonNull String getMessage(@Nullable String name) {
        name = StringUtil.nullStringToEmpty(name);
        
        return String.format("Hello, %s!", name);
    }
}
