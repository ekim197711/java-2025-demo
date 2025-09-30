package com.example.java25demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImportantDataServiceWithTypeReferenceTest {

    @Autowired
    ImportantDataServiceWithTypeReference importantData;

    @Test
    public void loadPerson() {
        Person mike = importantData.loadPerson("mike");
        Assertions.assertThat(mike).isNotNull();
        Assertions.assertThat(mike.getAge()).isEqualTo(47);
        Person nn = importantData.loadPerson("something");
        Assertions.assertThat(nn).isNotNull();
        Assertions.assertThat(nn.getAge()).isEqualTo(-1);
    }

    @Test
    void loadAnotherPerson() {
        AnotherPerson anotherPerson = importantData.loadAnotherPerson("susan");
        Assertions.assertThat(anotherPerson).isNotNull();
        Assertions.assertThat(anotherPerson.getAge()).isEqualTo(29);
        Assertions.assertThat(anotherPerson.getHeight()).isEqualTo(178);
    }
}