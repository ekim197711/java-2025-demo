package com.example.java25demo;

import com.fasterxml.jackson.core.type.TypeReference;
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
public class ImportantDataServiceWithTypeReference {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Person loadPerson(String name) {
        InputStream resourceAsStream = ImportantDataServiceWithTypeReference.class.getClassLoader()
                .getResourceAsStream("important_data.json");
        Map<String, Person> map = null;
        try {
            map = objectMapper.readValue(resourceAsStream,
                    new TypeReference<Map<String, Person>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Person person = map.getOrDefault(name, new Person("NN", -1, "0", "0"));
        person.setName(name);
        return person;
    }

    public AnotherPerson loadAnotherPerson(String name) {
        Person person = loadPerson(name);
        AnotherPerson anotherPerson = objectMapper.convertValue(person, AnotherPerson.class);
        return anotherPerson;
    }
}
