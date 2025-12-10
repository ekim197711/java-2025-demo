package com.example.java25demo;

import com.example.java25demo.hero.CoolHero;
import com.example.java25demo.hero.CoolHeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CoolHeroServiceTest {

    private final CoolHero thisMustBeThere = CoolHero.builder()
            .name("Terra Vanguard")
            .alias("Earthshaper")
            .experienceLevel(720)
            .heightCm(183)
            .weightKg(96.0)
            .primaryPower("Seismic control and stone armor")
            .homeBase("Bastion Outpost")
            .build();
    @Autowired
    private CoolHeroService coolHeroService;

    @Test
    void returnsDummyHeroRoster() {
        List<CoolHero> heroes = coolHeroService.getCoolHeroes();

        assertThat(heroes).hasSizeGreaterThan(0);
        assertThat(heroes)
                .extracting(CoolHero::getName)
                .contains("Nova Blaze", "Cobalt Sentry", "Void Whisper");

        assertThat(heroes)
                .anySatisfy(hero -> {
                    assertThat(hero.getExperienceLevel()).isBetween(0, 1000);
                    assertThat(hero.getName()).isNotNull();
                    assertThat(hero.getAlias()).isNotNull();
                });

        assertThat(heroes)
                .contains(thisMustBeThere);
    }
}
