package com.example.java25demo.hero.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/animal-rescued-stats")
@RequiredArgsConstructor
public class AnimalRescuedStatController {
    private final AnimalRescuedStatService service;
    private final AnimalRescuedStatRepository repository;

    @GetMapping
    public List<AnimalVillainsStatDto> getAll() {
        return repository.animalsAndVillains().stream().map(e ->
                new AnimalVillainsStatDto(e.getYear(), e.getWeek(), e.getQuantity(),
                        e.getVillainsDefeated().getQuantity())).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalRescuedStatEntity> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
