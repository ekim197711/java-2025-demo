package com.example.java25demo.hero.statistics;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "animal_rescued_stats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalRescuedStatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "year_number", nullable = false)
    private int year;

    @Column(name = "week_number", nullable = false)
    private int week;

    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "year_number", referencedColumnName = "year_number", insertable = false, updatable = false),
            @JoinColumn(name = "week_number", referencedColumnName = "week_number", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private VillainsDefeatedEntity villainsDefeated;
}
