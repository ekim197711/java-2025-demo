package com.example.java25demo.hero.statistics;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class VillainsDefeatedService {

    private final VillainsDefeatedRepository repository;
    private final Random random = new Random(2025);

    public VillainsDefeatedService(VillainsDefeatedRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void seedData() {
        if (repository.count() > 0) {
            return;
        }

        List<VillainsDefeatedEntity> stats = new ArrayList<>();
        for (int week = 1; week <= 52; week++) {
            stats.add(VillainsDefeatedEntity.builder()
                    .year(2025)
                    .week(week)
                    .quantity(3 + random.nextInt(30))
                    .build());
        }

        repository.saveAll(stats);
    }

    public List<VillainsDefeatedEntity> getAll() {
        return repository.findAll();
    }

    public Optional<VillainsDefeatedEntity> getById(Long id) {
        return repository.findById(id);
    }

    public VillainsDefeatedEntity save(VillainsDefeatedEntity entity) {
        return repository.save(entity);
    }
}
