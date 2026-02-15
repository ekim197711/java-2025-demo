package com.example.java25demo.hero.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRescuedStatRepository extends JpaRepository<AnimalRescuedStatEntity, Long> {

    @Query("""
            SELECT A FROM AnimalRescuedStatEntity A 
            LEFT JOIN FETCH A.villainsDefeated VD             
            """)
    List<AnimalRescuedStatEntity> animalsAndVillains();
}
