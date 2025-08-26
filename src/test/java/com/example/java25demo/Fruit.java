package com.example.java25demo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Fruit {
    int amount;
    String name;
}
