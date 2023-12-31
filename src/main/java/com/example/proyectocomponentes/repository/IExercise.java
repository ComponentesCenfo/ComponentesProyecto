package com.example.proyectocomponentes.repository;

import com.example.proyectocomponentes.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IExercise extends JpaRepository<Exercise, Integer> {
    @Query("SELECT e.name FROM Exercise e WHERE e.name = :name")
    public String byName(String name);
}
