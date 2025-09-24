package com.example.java25demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ImportantDataServiceTest {
    @Autowired
    private ImportantDataService importantDataService;

    @Test
    public void loadPerson() {
        Person mike = importantDataService.loadPerson("mike");
        Assertions.assertThat(mike).isNotNull();
        Assertions.assertThat(mike.getName()).isEqualToIgnoringCase("MIKE");
        Assertions.assertThat(mike.getAge()).isEqualTo(47);

        Person susan = importantDataService.loadPerson("susan");
        Assertions.assertThat(susan).isNotNull();
        Assertions.assertThat(susan.getAge()).isEqualTo(29);
        Assertions.assertThat(susan.getHeight()).isEqualTo("178");


    }
}