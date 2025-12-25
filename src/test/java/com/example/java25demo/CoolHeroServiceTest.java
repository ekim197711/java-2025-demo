package com.example.java25demo;

import com.example.java25demo.hero.CoolHero;
import com.example.java25demo.hero.CoolHeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

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
    void averageTheOldSlowWayTest() {
        List<CoolHero> heroes = coolHeroService.getCoolHeroes();
        int sum = 0;
        for (CoolHero hero : heroes) {
            sum += hero.getExperienceLevel();
        }
        double average = (double) sum / heroes.size();
        assertThat(average).isCloseTo(500, within(10.0));
    }


    @Test
    void averageTest() {
        List<CoolHero> heroes = coolHeroService.getCoolHeroes();
        assertThat(heroes).anySatisfy(
                hero -> {
                    assertThat(hero).hasNoNullFieldsOrProperties();
                });
        assertThat(heroes).allSatisfy(
                hero -> {
                    assertThat(hero).hasNoNullFieldsOrPropertiesExcept("alias");
                    assertThat(hero.getHeightCm()).isGreaterThanOrEqualTo(0);
                });

        IntSummaryStatistics stats = heroes.stream()
                .collect(Collectors.summarizingInt(CoolHero::getExperienceLevel));
        System.out.println(stats);
        assertThat(stats.getCount()).isGreaterThanOrEqualTo(20);
        assertThat(stats.getMin()).isGreaterThanOrEqualTo(0);
        assertThat(stats.getMax()).isLessThanOrEqualTo(1000);
        assertThat(stats.getAverage()).isCloseTo(500, within(10.0));
    }


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
