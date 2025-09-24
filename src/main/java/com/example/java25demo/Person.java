package com.example.java25demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String name;
    private int age;
    private String height;
    private String weight;
}
