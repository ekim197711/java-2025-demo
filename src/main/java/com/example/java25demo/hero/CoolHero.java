package com.example.java25demo.hero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoolHero {
    private String name;
    private String alias;
    private int experienceLevel;
    private int heightCm;
    private double weightKg;
    private String primaryPower;
    private String homeBase;
}