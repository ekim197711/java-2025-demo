package com.example.java25demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImportantDataService {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Person loadPerson(String name) {
        InputStream resourceAsStream = ImportantDataService.class.getClassLoader()
                .getResourceAsStream("important_data.json");
        Map<String, Object> map = null;
        try {
            map = objectMapper.readValue(resourceAsStream, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Person person = objectMapper.convertValue(map.get(name), Person.class);
        person.setName(name);
        return person;
    }
}
