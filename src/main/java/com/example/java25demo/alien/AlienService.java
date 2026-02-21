package com.example.java25demo.alien;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlienService {
    private final AlienGeneratorService alienGeneratorService;

    private NameAndColor greatestNameAndColor() {
        Alien first = alienGeneratorService.generateAliens().getFirst();
        return new NameAndColor(first.getName(), first.getColor());
    }

    public Map<ColorAndStarSystem, List<Alien>> fetchAliensByColorAndStarSystem() {
        List<Alien> aliens = alienGeneratorService.generateAliens();
        return aliens.stream().collect(
                Collectors.groupingBy(a -> new ColorAndStarSystem(a.getColor(), a.getStarSystem())));
    }

    record ColorAndStarSystem(String color, String starSystem) {
        String combinedName() {
            return color + " " + starSystem;
        }
    }
    private record NameAndColor(String name, String color) {
    }
}
