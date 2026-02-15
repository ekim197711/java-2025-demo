package com.example.java25demo.hero.statistics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "villains_defeated")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Service
public class VillainsDefeatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "year_number", nullable = false)
    private int year;

    @Column(name = "week_number", nullable = false)
    private int week;

    @Column(nullable = false)
    private int quantity;

    @ToString.Exclude
    @OneToOne(mappedBy = "villainsDefeated")
    @JsonIgnore
    private AnimalRescuedStatEntity animalRescuedStatEntity;
}
