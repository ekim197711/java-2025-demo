package com.example.java25demo.alien;

import com.example.java25demo.alien.AlienService.ColorAndStarSystem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class AlienServiceTest {

    @Autowired
    AlienService alienService;

    @Test
    void fetchAliensByColorAndStarSystem() {
        Map<ColorAndStarSystem, List<Alien>> colorAndStarSystemAlienMap = alienService.fetchAliensByColorAndStarSystem();
        Assertions.assertThat(colorAndStarSystemAlienMap).isNotEmpty();
        Assertions.assertThat(colorAndStarSystemAlienMap.values())
                .allSatisfy(values -> Assertions.assertThat(values)
                        .allSatisfy(v -> Assertions.assertThat(v).hasNoNullFieldsOrProperties()));
        colorAndStarSystemAlienMap.entrySet().forEach(System.out::println);
        System.out.println("========================== COMBINED NAMES ========================");
        colorAndStarSystemAlienMap.keySet().stream().map(ColorAndStarSystem::combinedName).forEach(System.out::println);

        System.out.println("==========================");
    }
}