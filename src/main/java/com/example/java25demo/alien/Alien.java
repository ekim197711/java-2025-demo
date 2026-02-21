package com.example.java25demo.alien;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alien {
    private String name;
    private String color;
    private String starSystem;
}
