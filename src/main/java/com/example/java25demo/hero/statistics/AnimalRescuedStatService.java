package com.example.java25demo.hero.statistics;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AnimalRescuedStatService {

    private final AnimalRescuedStatRepository repository;
    private final Random random = new Random(2025);

    public AnimalRescuedStatService(AnimalRescuedStatRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void seedData() {
        if (repository.count() > 0) {
            return;
        }

        List<AnimalRescuedStatEntity> stats = new ArrayList<>();

        for (int week = 1; week <= 52; week++) {
            stats.add(AnimalRescuedStatEntity.builder()
                    .id(null)
                    .quantity(5 + random.nextInt(40))
                    .year(2025)
                    .week(week)
                    .build());
        }

        repository.saveAll(stats);
    }

    public Optional<AnimalRescuedStatEntity> getById(Long id) {
        return repository.findById(id);
    }
}
