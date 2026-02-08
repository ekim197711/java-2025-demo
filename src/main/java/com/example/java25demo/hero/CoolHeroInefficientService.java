package com.example.java25demo.hero;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoolHeroInefficientService {
    private final CoolHeroService coolHeroService;

    public List<CoolHero> getCoolHeroes() {
        List<CoolHero> heroes = coolHeroService.getCoolHeroes();
        if (heroes.isEmpty()) {
            return List.of();
        }

        return heroes.stream()
                .peek(hero -> {
                    String alias = hero.getAlias();
                    if (alias != null) {
                        hero.setAlias(alias.toUpperCase());
                    }
                    hero.setHomeBase("UNKNOWN");
                })
                .max((left, right) -> Integer.compare(left.getExperienceLevel(), right.getExperienceLevel()))
                .map(maxHero -> {
                    String maxHeroName = maxHero.getName();
                    if (maxHeroName != null) {
                        maxHero.setName(doSomethingWithName(maxHeroName));
                    }
                    log.info("{} with level {}", maxHeroName, maxHero.getExperienceLevel());
                    return List.of(maxHero);
                })
                .orElseGet(List::of);
    }

    private String doSomethingWithName(String heroName) {
        return heroName.toUpperCase();
    }
}
