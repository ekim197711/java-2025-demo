package com.example.java25demo.hero;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoolHeroInefficientServiceTest {

    @Autowired
    CoolHeroInefficientService coolHeroInefficientService;

    @Test
    void getCoolHeroes() {
        List<CoolHero> coolHeroes = coolHeroInefficientService.getCoolHeroes();
        Assertions.assertThat(coolHeroes).isNotEmpty();
        coolHeroes.forEach(System.out::println);
        System.out.println("==========================");
        Assertions.assertThat(coolHeroes.getFirst().getName()).isEqualTo("COBALT SENTRY");
    }
}