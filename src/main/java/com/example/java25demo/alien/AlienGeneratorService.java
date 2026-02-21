package com.example.java25demo.alien;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienGeneratorService {

    List<Alien> generateAliens() {
        return List.of(
                Alien.builder()
                        .color("green")
                        .starSystem("Milky Way")
                        .name("Alien 1")
                        .build(), Alien.builder()
                        .color("green")
                        .starSystem("Milky Way")
                        .name("Alien 2")
                        .build(), Alien.builder()
                        .color("yellow")
                        .starSystem("GalaxyFarFarAway")
                        .name("Alien 3")
                        .build(), Alien.builder()
                        .color("red")
                        .starSystem("GalaxyFarFarAway")
                        .name("Alien 4")
                        .build(), Alien.builder()
                        .color("yellow")
                        .starSystem("GalaxyFarFarAway")
                        .name("Alien 5")
                        .build()
        );
    }

}
